package com.deepak.cleanarchitecturecomposeproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company
import com.deepak.cleanarchitecturecomposeproject.data.response.Geo
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.domain.usecase.GetUsersUseCase
import com.deepak.cleanarchitecturecomposeproject.ui.users.UsersViewModel
import com.deepak.cleanarchitecturecomposeproject.utils.Resource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@HiltAndroidTest
@ExperimentalCoroutinesApi
class UsersViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var getUsersUseCase: GetUsersUseCase

    @InjectMocks
    lateinit var usersViewModel: UsersViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        hiltRule.inject()
    }

    @Test
    fun `test loading state`() = runBlockingTest {
        // Arrange
        `when`(getUsersUseCase.users).thenReturn(flowOf(Resource.Loading))

        // Act
        usersViewModel.getUsers()

        // Assert
        assertEquals(true, usersViewModel.state.value.isLoading)
    }

    @Test
    fun `test success state`() = runBlockingTest {
        // Arrange
        val userList = listOf(UserUiModel(Address("", Geo("",""),"","",""), Company("","",""),"",1,"","","",""),
            UserUiModel(Address("", Geo("",""),"","",""), Company("","",""),"",1,"","","",""))
                `when`(getUsersUseCase.users).thenReturn(flowOf(Resource.Success(userList)))

        // Act
        usersViewModel.getUsers()

        // Assert
        assertEquals(userList, usersViewModel.state.value.users)
        assertEquals(userList, usersViewModel.allUsers)
    }

    @Test
    fun `test error state`() = runTest {
        // Arrange
        val errorMessage = "Error fetching users"
        `when`(getUsersUseCase.users).thenReturn(flowOf(Resource.Error(errorMessage)))

        // Act
        usersViewModel.getUsers()

        // Assert
        assertEquals(errorMessage, usersViewModel.state.value.error)
    }
}

package com.deepak.cleanarchitecturecomposeproject

import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company
import com.deepak.cleanarchitecturecomposeproject.data.response.Geo
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponseItem
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class UsersRepositoryTest {

    @Mock
    private lateinit var usersRepository: UsersRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getUsers should return UserResponse`() = runBlocking {
        val mockUserList = listOf(
            UserResponseItem(
            Address("add", Geo("1","1"),"djdj","aa","111"),
            Company("aa","aa","aa"),"a",1,"a","a","a","a"
            )
        )

        val mockUserResponse = UserResponse()
        mockUserResponse.addAll(mockUserList)
        `when`(usersRepository.getUsers()).thenReturn(mockUserResponse)

        // Act
        val result = usersRepository.getUsers()
        assertEquals(mockUserResponse, result)
    }
    @Test
    fun `getUsers should return EmptyUserResponse`() = runBlocking {
        // Arrange

        val mockUserResponse = UserResponse()
        `when`(usersRepository.getUsers()).thenReturn(mockUserResponse)

        // Act
        val result = usersRepository.getUsers()
        assertEquals(mockUserResponse, result)
    }

}

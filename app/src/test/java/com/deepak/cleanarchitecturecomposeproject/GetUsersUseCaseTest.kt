package com.deepak.cleanarchitecturecomposeproject

import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.domain.usecase.GetUsersUseCase
import com.deepak.cleanarchitecturecomposeproject.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetUsersUseCaseTest {

    @Mock
    private lateinit var usersRepository: UsersRepository

    @InjectMocks
    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getUsers should emit loading and success`() = runBlocking {
        // Arrange
        val mockUserUiModelList = (UserResponse(/* mock your user UI model here */))
        `when`(usersRepository.getUsers()).thenReturn(mockUserUiModelList)

        // Act & Assert
        getUsersUseCase.users.collect { result ->
            when (result) {
                is Resource.Loading -> {
                    // Add your assertions for loading state
                }
                is Resource.Success -> {
                    // Add your assertions for success state
                    // For example: assertEquals(mockUserUiModelList, result.data)
                }
                is Resource.Error -> {
                    // Add your assertions for error state
                }
            }
        }
    }

    @Test
    fun `getUsers should emit loading and Exception`() = runBlocking {
        // Arrange
        val mockUserUiModelList = (UserResponse(/* mock your user UI model here */))
        `when`(usersRepository.getUsers()).thenThrow(RuntimeException("Mocked exception"))

        // Act & Assert
        getUsersUseCase.users.collect { result ->
            when (result) {
                is Resource.Loading -> {
                    // Add your assertions for loading state
                }
                is Resource.Success -> {
                    // Add your assertions for success state
                    // For example: assertEquals(mockUserUiModelList, result.data)
                }
                is Resource.Error -> {
                    // Add your assertions for error state
                }
            }
        }
    }

}

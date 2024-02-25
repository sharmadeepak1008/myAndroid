package com.deepak.cleanarchitecturecomposeproject

import com.deepak.cleanarchitecturecomposeproject.data.mapper.toUserUiModel
import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company
import com.deepak.cleanarchitecturecomposeproject.data.response.Geo
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponseItem
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.domain.usecase.GetUsersUseCase
import com.deepak.cleanarchitecturecomposeproject.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
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
        MockitoAnnotations.initMocks(this)
        getUsersUseCase = GetUsersUseCase(usersRepository)
    }

    @Test
    fun `getUsers should emit loading and success`() = runBlocking {
        // Arrange
        val mockUserList = listOf(
            UserResponseItem(
                Address("address", Geo("1.1","1.1"),"23","aa","111111"),
                Company("aa","aa","aa"),"a",1,"a","a","a","a"
            )
        )
        val mockUserResponse = UserResponse()
        mockUserResponse.addAll(mockUserList)

        val mockUserUiModelList = (mockUserResponse)
        `when`(usersRepository.getUsers()).thenReturn(mockUserUiModelList)

        getUsersUseCase.users.collect { result ->
            when (result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    assertEquals(mockUserResponse.map { it.toUserUiModel() },result.data)

                }
                is Resource.Error -> {
                    Assert.assertNotEquals(mockUserResponse,result.errorMessage)

                }
            }
        }
    }
    @Test
    fun `getUsers should emit emptyResponse`() = runBlocking {
        val mockUserResponse = UserResponse()
        val mockUserUiModelList = (mockUserResponse)
        `when`(usersRepository.getUsers()).thenReturn(mockUserUiModelList)

        getUsersUseCase.users.collect { result ->
            when (result) {
                is Resource.Loading -> {
                    Assert.assertTrue(true)
                }
                is Resource.Success -> {
                    assertEquals(mockUserResponse.map { it.toUserUiModel() },result.data)

                }
                is Resource.Error -> {
                    Assert.assertNotEquals(mockUserResponse,result.errorMessage)

                }
            }
        }
    }

    @Test
    fun `test success case`() {
        runBlocking {
            `when`(usersRepository.getUsers()).thenReturn(UserResponse())

            val result = getUsersUseCase.users.toList()

            assertEquals(result[0], Resource.Loading)
            assertEquals(result[1], Resource.Success(UserResponse()))
        }
    }
    @Test
    fun `get users should emit loading and Exception`() {
        runBlocking {
            `when`(usersRepository.getUsers()).thenThrow(RuntimeException("Mocked exception"))

            val result = getUsersUseCase.users.toList()

            assertEquals(result[0], Resource.Loading)
            assertEquals(result[1], Resource.Error(errorMessage ="Error !!" ))
        }
    }
}

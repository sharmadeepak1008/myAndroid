package com.deepak.cleanarchitecturecomposeproject

import com.deepak.cleanarchitecturecomposeproject.data.mapper.toUserUiModel
import com.deepak.cleanarchitecturecomposeproject.data.remote.Service
import com.deepak.cleanarchitecturecomposeproject.data.repository.UsersRepositoryImpl
import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company
import com.deepak.cleanarchitecturecomposeproject.data.response.Geo
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponseItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ServiceTest {

    @Mock
    private lateinit var mockService: Service

    private lateinit var userManager: UsersRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        userManager = UsersRepositoryImpl(mockService)
    }

    @Test
    fun testGetUsers_Success() = runBlocking {
        // Mocking the response from the service
        val mockUserList = listOf(
            UserResponseItem(
                Address("add", Geo("1","1"),"djdj","aa","111"),
                Company("aa","aa","aa"),"a",1,"a","a","a","a"
            )
        )
        val mockUserResponse = UserResponse()
        mockUserResponse.addAll(mockUserList)
        `when`(mockService.getUsers()).thenReturn(mockUserResponse)

        // Calling the actual method in UserManager
        val result: UserResponse = userManager.getUsers()

        // Verifying that the service method is called
        // and the result matches the mocked response
        `when`(mockService.getUsers()).thenReturn(mockUserResponse)
        assertEquals(mockUserResponse, result)
    }
}
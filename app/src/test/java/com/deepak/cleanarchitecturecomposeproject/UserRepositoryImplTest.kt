package com.deepak.cleanarchitecturecomposeproject

import com.deepak.cleanarchitecturecomposeproject.data.remote.Service
import com.deepak.cleanarchitecturecomposeproject.data.repository.UsersRepositoryImpl
import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company
import com.deepak.cleanarchitecturecomposeproject.data.response.Geo
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponseItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class UsersRepositoryImplTest {

    @Mock
    private lateinit var service: Service

    @InjectMocks
    private lateinit var usersRepository: UsersRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getUsers should return UserResponse`() = runBlocking {
        // Arrange
        val mockUserList = listOf(
            UserResponseItem(
                Address("add", Geo("1","1"),"djdj","aa","111"),
                Company("aa","aa","aa"),"a",1,"a","a","a","a"
                )
        )

        val mockUserResponse = UserResponse()
        mockUserResponse.addAll(mockUserList)
        `when`(service.getUsers()).thenReturn(mockUserResponse)

        // Act
        val result = usersRepository.getUsers()

        // Assert
        Assert.assertEquals(mockUserResponse, result)

    }
    @Test
    fun `getUsers should return EmptyUserResponse`() = runBlocking {
        // Arrange
        val mockUserResponse = UserResponse()
        `when`(service.getUsers()).thenReturn(mockUserResponse)

        // Act
        val result = usersRepository.getUsers()

        // Assert
        Assert.assertEquals(mockUserResponse, result)
    }
}

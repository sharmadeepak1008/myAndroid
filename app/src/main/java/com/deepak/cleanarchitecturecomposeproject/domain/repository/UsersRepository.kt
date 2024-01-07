package com.deepak.cleanarchitecturecomposeproject.domain.repository

import com.deepak.cleanarchitecturecomposeproject.data.response.APIResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse

interface UsersRepository {

    suspend fun getUsers(): UserResponse

    suspend fun getTopNews(country : String, page : Int): APIResponse

}
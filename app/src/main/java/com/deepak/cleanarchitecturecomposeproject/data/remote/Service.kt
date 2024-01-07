package com.deepak.cleanarchitecturecomposeproject.data.remote

import com.deepak.cleanarchitecturecomposeproject.data.response.APIResponse
import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.utils.Constants.API_KEY
import com.deepak.cleanarchitecturecomposeproject.utils.Constants.TOP_NEWS
import com.deepak.cleanarchitecturecomposeproject.utils.Constants.USERS
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(USERS)
    suspend fun getUsers(): UserResponse

}
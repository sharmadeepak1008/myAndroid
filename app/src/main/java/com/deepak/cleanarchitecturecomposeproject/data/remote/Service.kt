package com.deepak.cleanarchitecturecomposeproject.data.remote

import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.utils.Constants.USERS
import retrofit2.http.GET

interface Service {

    @GET(USERS)
    suspend fun getUsers(): UserResponse

}
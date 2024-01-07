package com.deepak.cleanarchitecturecomposeproject.data.repository

import com.deepak.cleanarchitecturecomposeproject.data.response.UserResponse
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
import com.deepak.cleanarchitecturecomposeproject.data.remote.Service
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val service: Service): UsersRepository {

    override suspend fun getUsers(): UserResponse = service.getUsers()


}
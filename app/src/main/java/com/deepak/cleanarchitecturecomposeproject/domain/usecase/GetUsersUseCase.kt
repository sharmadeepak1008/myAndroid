package com.deepak.cleanarchitecturecomposeproject.domain.usecase

import com.deepak.cleanarchitecturecomposeproject.data.mapper.toUserUiModel
import com.deepak.cleanarchitecturecomposeproject.domain.repository.UsersRepository
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    val users: Flow<Resource<List<UserUiModel>>> = flow {

        try {
            emit(Resource.Loading)
            emit(Resource.Success(usersRepository.getUsers().map { it.toUserUiModel() }))
        } catch (e: Exception) {
            emit(Resource.Error("Error !!"))
        }
    }
}
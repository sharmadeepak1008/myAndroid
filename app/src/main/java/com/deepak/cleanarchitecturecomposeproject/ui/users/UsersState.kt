package com.deepak.cleanarchitecturecomposeproject.ui.users

import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel

data class UsersState(
    val isLoading: Boolean = false,
    val users: List<UserUiModel> = emptyList(),
    val error: String = ""
)
package com.deepak.cleanarchitecturecomposeproject.domain.uimodel

import com.deepak.cleanarchitecturecomposeproject.data.response.Address
import com.deepak.cleanarchitecturecomposeproject.data.response.Company


data class UserUiModel(
    val address: Address?,
    val company: Company?,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
)
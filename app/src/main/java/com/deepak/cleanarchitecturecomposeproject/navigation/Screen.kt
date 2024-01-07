package com.deepak.cleanarchitecturecomposeproject.navigation

sealed class Screen(val route: String){
    object Users : Screen("user_list_screen")
}

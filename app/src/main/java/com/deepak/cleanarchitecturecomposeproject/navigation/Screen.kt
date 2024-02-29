package com.deepak.cleanarchitecturecomposeproject.navigation

sealed class Screen(val route: String){
    object Users : Screen("user_list_screen")
    object UserName : Screen("user_name_screen")
    object Website : Screen("user_website_screen")
}

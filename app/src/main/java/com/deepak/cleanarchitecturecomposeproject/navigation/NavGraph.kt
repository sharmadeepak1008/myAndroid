package com.deepak.cleanarchitecturecomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.deepak.cleanarchitecturecomposeproject.ui.users.UsersScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Users.route){
        composable(Screen.Users.route){
            UsersScreen()
        }
    }
}
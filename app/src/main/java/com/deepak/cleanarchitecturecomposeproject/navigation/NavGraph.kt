package com.deepak.cleanarchitecturecomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.deepak.cleanarchitecturecomposeproject.ui.users.BrowserScreen
import com.deepak.cleanarchitecturecomposeproject.ui.users.ShowDetailScreen
import com.deepak.cleanarchitecturecomposeproject.ui.users.UsersScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Users.route){
        composable(Screen.Users.route){
            UsersScreen(navController= navController)
        }
        composable(Screen.UserName.route+"/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username: String = backStackEntry.arguments?.getString("username").toString()
            ShowDetailScreen(username)
        }

        composable(Screen.Website.route+"/{website}",
            arguments = listOf(navArgument("website") { type = NavType.StringType })
        ) { backStackEntry ->
            val websiteUrl:String = backStackEntry.arguments?.getString("website").toString()
            BrowserScreen(websiteUrl)
        }

/*
        composable(Screen.Website.route){
            val url:String=""
            BrowserScreen(url)
        }
*/

    }
}

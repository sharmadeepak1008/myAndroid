package com.deepak.cleanarchitecturecomposeproject.ui.users

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.navigation.Screen
import com.deepak.cleanarchitecturecomposeproject.ui.theme.Teal200
import com.deepak.cleanarchitecturecomposeproject.utils.ErrorText


@Composable
fun UsersScreen(viewModel: UsersViewModel = hiltViewModel(),navController: NavController) {
    val userValue= viewModel.itemData.collectAsState(initial = null)
    val itemValue= viewModel.itemType.collectAsState(initial = null)

    if (itemValue.value.equals("username")) {
        userValue.value?.let {
            navController.navigate(
                Screen.UserName.route + "/${it.username}"
            )
        }
    }
    else if (itemValue.value.equals("website")){
        userValue.value?.let {
            navController.navigate(
                Screen.Website.route+ "/${it.website}"
            )
        }

        }


    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        UserList(viewModel,navController)
        CircularProgressDialog(viewModel)
        CheckError(viewModel)
    }
}

@Composable
fun UserList(viewModel: UsersViewModel = hiltViewModel(),navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(12.dp)) {
        items(viewModel.state.value.users,key={
            it.id
        }) { userItem ->
            UserItem(userUiModel = userItem, navController,viewModel )
        }
    }
}

@Composable
fun CircularProgressDialog(viewModel: UsersViewModel = hiltViewModel()){
    if (viewModel.state.value.isLoading) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Teal200
            )
        }
    }
}

@Composable
fun CheckError(viewModel: UsersViewModel = hiltViewModel()){
    Box{
        if (viewModel.state.value.error.isNotBlank()){
            ErrorText(viewModel.state.value.error, Modifier.align(Alignment.Center))
        }
    }
}
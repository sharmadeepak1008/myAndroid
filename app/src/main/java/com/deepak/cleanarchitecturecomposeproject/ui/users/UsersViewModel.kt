package com.deepak.cleanarchitecturecomposeproject.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.UserUiModel
import com.deepak.cleanarchitecturecomposeproject.domain.usecase.GetUsersUseCase
import com.deepak.cleanarchitecturecomposeproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase): ViewModel() {

    var allUsers = listOf<UserUiModel>()
    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state
    private val _itemData= MutableSharedFlow<UserUiModel>()
    val itemData=_itemData.asSharedFlow()
    private val _itemType= MutableSharedFlow<String>()
    val itemType=_itemType.asSharedFlow()


    init {
        getUsers()
    }

    fun getUsers() {
        getUsersUseCase.users.onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = UsersState(isLoading = true)
                is Resource.Success -> {
                    result.data.let {
                        _state.value = UsersState(users = it)
                        allUsers = it
                        
                    }
                }
                is Resource.Error -> _state.value = UsersState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }

    fun redirectUserScreen(userUiModel: UserUiModel,clickType:String){
        viewModelScope.launch {
            _itemData.emit(userUiModel)
            _itemType.emit(clickType)
        }
    }




}
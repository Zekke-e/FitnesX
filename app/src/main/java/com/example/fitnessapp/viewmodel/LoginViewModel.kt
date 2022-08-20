package com.example.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.use_cases.login.LoginUseCases
import com.example.fitnessapp.view.login.LoginStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RoomRepository,
    private val dataStoreRepository: DataStoreRepository,
    private val loginUseCases: LoginUseCases
) : ViewModel() {

    private val _loginUiState = MutableStateFlow<LoginStates>(LoginStates.Empty)
    val loginUiState: StateFlow<LoginStates> = _loginUiState

    fun loginUser(userEmail: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        _loginUiState.value = LoginStates.Loading
        try {
            _loginUiState.value = LoginStates.Loading
            delay(1000L)
            if (repository.getUserEmail(userEmail, password).isEmpty()) {
                throw IllegalAccessException("Empty")
            }
        } catch (e: IllegalAccessException) {
            println("ERROR")
            _loginUiState.value = LoginStates.Error(message = "Bad email or password")
            return@launch
        }
        _loginUiState.value = LoginStates.Success
    }

    fun saveUserLoginState(completed: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveUserLoginState(completed = completed)
        }
    }
}
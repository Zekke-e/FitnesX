package com.example.fitnessapp.view.login

sealed class LoginStates {
    object Success : LoginStates()
    data class Error(val message: String) : LoginStates()
    object Loading : LoginStates()
    object Empty : LoginStates()
}
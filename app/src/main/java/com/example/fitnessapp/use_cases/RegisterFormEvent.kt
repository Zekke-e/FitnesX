package com.example.fitnessapp.use_cases

sealed class RegisterFormEvent {
    data class EmailChanged(val email: String) : RegisterFormEvent()
    data class LastNameChanged(val lastName: String) : RegisterFormEvent()
    data class NameChanged(val name: String) : RegisterFormEvent()
    data class PasswordChanged(val password: String) : RegisterFormEvent()
    data class TermChanged(val term: Boolean) : RegisterFormEvent()

    object Submit : RegisterFormEvent()
}
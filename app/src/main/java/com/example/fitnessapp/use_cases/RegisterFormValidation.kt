package com.example.fitnessapp.use_cases

data class RegisterFormValidation(
    val name: String = "",
    val nameError: String? = null,
    val lastName: String = "",
    val lastNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val termAccept: Boolean = false,
    val termAcceptError: String? = null
)

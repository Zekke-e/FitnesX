package com.example.fitnessapp.use_cases.login

data class LoginUseCases(
    val checkUserEmailCredentials: CheckUserEmailCredentials,
    val checkUserPasswordCredentials: CheckUserPasswordCredentials
)
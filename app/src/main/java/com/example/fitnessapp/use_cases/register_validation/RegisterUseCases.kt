package com.example.fitnessapp.use_cases.register_validation

data class RegisterUseCases(
    val emailValidation: EmailValidation,
    val lastNameValidation: LastNameValidation,
    val nameValidation: NameValidation,
    val passwordValidation: PasswordValidation,
    val termValidation: TermValidation
)

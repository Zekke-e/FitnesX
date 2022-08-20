package com.example.fitnessapp.use_cases.login

import com.example.fitnessapp.use_cases.ValidationResult

class CheckUserPasswordCredentials {

    fun checkUserPassword(userPassword: String, repoPassword: String): ValidationResult {
        return if (userPassword == repoPassword)
            ValidationResult(successful = true)
        else
            ValidationResult(successful = false, errorMessage = "Wrong Password")
    }
}
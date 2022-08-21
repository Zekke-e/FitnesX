package com.example.fitnessapp.use_cases.login

import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.use_cases.ValidationResult
import javax.inject.Inject

class CheckUserPasswordCredentials @Inject constructor(
    private val repository: RoomRepository
) {
    suspend fun checkUserPassword(userPassword: String): ValidationResult {
        val repoPassword = repository.getUserPassword(userPassword)
        return if (userPassword.isNotEmpty())
            ValidationResult(successful = true)
        else
            ValidationResult(successful = false, errorMessage = "Wrong Password")
    }
}
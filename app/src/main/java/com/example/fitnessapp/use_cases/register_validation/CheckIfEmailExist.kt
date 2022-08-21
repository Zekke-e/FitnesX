package com.example.fitnessapp.use_cases.register_validation

import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.use_cases.ValidationResult
import javax.inject.Inject

class CheckIfEmailExist @Inject constructor(
    private val repository: RoomRepository
) {
    suspend fun execute(emailExist: String): ValidationResult {
        return try {
            if (repository.checkIfEmailExists(userEmail = emailExist).isEmpty()) {
                throw NullPointerException("null")
            }
            ValidationResult(successful = false, errorMessage = "Email exists")
        } catch (e: NullPointerException) {
            ValidationResult(successful = true)
        }
    }
}
package com.example.fitnessapp.use_cases.register_validation

import com.example.fitnessapp.use_cases.ValidationResult

class LastNameValidation {

    fun execute(lastName: String): ValidationResult {
        if (lastName.isEmpty()) {
            return ValidationResult(successful = false, errorMessage = "Last Name cannot be empty")
        }
        return ValidationResult(successful = true)
    }
}
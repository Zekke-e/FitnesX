package com.example.fitnessapp.use_cases.register_validation

import com.example.fitnessapp.use_cases.ValidationResult

class NameValidation {

    fun execute(name: String): ValidationResult {
        if (name.isEmpty()) {
            return ValidationResult(successful = false, errorMessage = "Name cannot be empty")
        }
        return ValidationResult(successful = true)
    }
}
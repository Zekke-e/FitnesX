package com.example.fitnessapp.use_cases.register_validation

import com.example.fitnessapp.use_cases.ValidationResult

class TermValidation {

    fun execute(accepted: Boolean): ValidationResult {

        if (!accepted) {
            return ValidationResult(successful = false, errorMessage = "Please accept terms")
        }
        return ValidationResult(successful = true)
    }
}
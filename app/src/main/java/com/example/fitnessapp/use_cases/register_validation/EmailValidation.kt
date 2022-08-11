package com.example.fitnessapp.use_cases.register_validation

import android.util.Patterns
import com.example.fitnessapp.use_cases.ValidationResult

class EmailValidation {
    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(successful = false, errorMessage = "Email can't be empty")
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(successful = false, errorMessage = "Wrong email")
        }

        return ValidationResult(successful = true)
    }
}
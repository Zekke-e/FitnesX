package com.example.fitnessapp.use_cases.register_validation

import com.example.fitnessapp.use_cases.ValidationResult

class PasswordValidation {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(successful = false, errorMessage = "Password must have more than 8 digits")
        }
        val containsLetterAndDigits = password.any { it.isLetter() } && password.any { it.isDigit() }
        if (!containsLetterAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "Password must contain at least one letter and digit"
            )
        }
        return ValidationResult(successful = true)
    }
}
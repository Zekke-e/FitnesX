package com.example.fitnessapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.use_cases.RegisterFormEvent
import com.example.fitnessapp.use_cases.RegisterFormValidation
import com.example.fitnessapp.use_cases.register_validation.RegisterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: DataStoreRepository,
    private val registerUseCases: RegisterUseCases

) : ViewModel() {
    fun saveOnBoardingState(completed: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

    var state by mutableStateOf(RegisterFormValidation())
    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegisterFormEvent) {
        when (event) {
            is RegisterFormEvent.PasswordChanged -> state = state.copy(password = event.password)
            is RegisterFormEvent.EmailChanged -> state = state.copy(email = event.email)
            is RegisterFormEvent.LastNameChanged -> state = state.copy(lastName = event.lastName)
            is RegisterFormEvent.NameChanged -> state = state.copy(name = event.name)
            is RegisterFormEvent.TermChanged -> state = state.copy(termAccept = event.term)
            is RegisterFormEvent.EmailExists -> state = state.copy(emailExists = event.emailExist)
            is RegisterFormEvent.Submit -> submitData()
        }
    }

    private fun submitData() {

        val emailResult = registerUseCases.emailValidation.execute(state.email)
        val lastNameResult = registerUseCases.lastNameValidation.execute(state.lastName)
        val nameResult = registerUseCases.nameValidation.execute(state.name)
        val passwordResult = registerUseCases.passwordValidation.execute(state.password)
        val termResult = registerUseCases.termValidation.execute(state.termAccept)


        val hasError = listOf(
            emailResult, lastNameResult, nameResult, passwordResult, termResult
        ).any { !it.successful }
        state = state.copy(
            emailError = emailResult.errorMessage,
            lastNameError = lastNameResult.errorMessage,
            nameError = nameResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            termAcceptError = termResult.errorMessage,
        )

        if (hasError) {
            return
        }

        viewModelScope.launch {
            if (registerUseCases.checkIfEmailExist.execute(state.email).successful) {
                validationEventChannel.send(ValidationEvent.Success)
            } else
                validationEventChannel.send(ValidationEvent.Error)
        }


    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
        object Error : ValidationEvent()
    }
}
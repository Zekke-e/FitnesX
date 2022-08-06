package com.example.fitnessapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _startDestination = MutableLiveData<Int>()
    val startDestination: LiveData<Int>
        get() = _startDestination


    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                when (completed) {
                    1 -> _startDestination.value = Screen.Login.route
                    else -> _startDestination.value = Screen.OnBoarding.route
                }
            }
        }
        _isLoading.value = false
    }
}
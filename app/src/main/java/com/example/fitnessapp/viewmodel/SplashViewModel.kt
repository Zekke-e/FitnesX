package com.example.fitnessapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
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

    private val _userLoggedState = MutableLiveData<Int>()
    val userLoggedState: LiveData<Int>
        get() = _userLoggedState


    init {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    listOf(
                        launch {
                            repository.readOnBoardingState().collect { completed ->
                                when (completed) {
                                    1 -> _startDestination.value = Screen.Login.route
                                    else -> _startDestination.value = Screen.OnBoarding.route
                                }
                            }
                        },
                        launch {
                            repository.readUserLoginState().collect { completed ->
                                when (completed) {
                                    1 -> _userLoggedState.value = 1
                                    else -> _userLoggedState.value = 0
                                }
                            }
                        }
                    ).joinAll()
                }
            } catch (e: Throwable) {
                println("error")
            }
        }
        _isLoading.value = false
    }
}

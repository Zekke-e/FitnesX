package com.example.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.data.repository.entities.RegisterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {

    suspend fun insertUser(userData: RegisterEntity) {
        repository.insertUser(userData)
    }
}
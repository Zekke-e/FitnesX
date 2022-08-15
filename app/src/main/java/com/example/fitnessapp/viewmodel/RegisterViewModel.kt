package com.example.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.data.repository.entities.RegisterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {

    suspend fun insertUser(userData: RegisterEntity) {
        repository.insertUser(userData)
    }

    suspend fun getUser(id: Int): String {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUser(id)
        }
        return repository.getUser(id)

    }
}
package com.example.fitnessapp.data.repository

import com.example.fitnessapp.data.repository.entities.RegisterEntity
import javax.inject.Inject

class RoomRepository @Inject constructor(private val registerDao: RegisterDao) {

    suspend fun insertUser(userData: RegisterEntity) = registerDao.insertUser(userData = userData)

    suspend fun getUserEmail(userEmail: String, userPassword: String): List<String> {
        return registerDao.getUserEmail(userEmail, userPassword)
    }
}
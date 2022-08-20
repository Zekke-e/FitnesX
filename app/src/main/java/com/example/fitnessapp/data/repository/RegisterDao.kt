package com.example.fitnessapp.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnessapp.data.repository.entities.RegisterEntity

@Dao
interface RegisterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userData: RegisterEntity)

    @Query("SELECT EmailLogin FROM RegisterEntity where EmailLogin LIKE :userEmail AND Password LIKE :password")
    suspend fun getUserEmail(userEmail: String, password: String): List<String>
}
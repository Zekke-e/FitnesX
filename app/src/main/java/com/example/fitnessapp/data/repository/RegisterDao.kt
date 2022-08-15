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

    @Query("SELECT Login FROM RegisterEntity where userID =:id")
    suspend fun getUser(id: Int): String
}
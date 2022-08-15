package com.example.fitnessapp.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnessapp.data.repository.entities.RegisterEntity

@Database(entities = [RegisterEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun RegisterDao(): RegisterDao
}
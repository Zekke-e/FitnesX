package com.example.fitnessapp.data.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegisterEntity")
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userID")
    val userId:Int,
    @ColumnInfo(name = "Login")
    val userLogin:String,

)
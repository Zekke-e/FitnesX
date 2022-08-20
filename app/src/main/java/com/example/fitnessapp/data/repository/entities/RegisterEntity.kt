package com.example.fitnessapp.data.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegisterEntity")
data class RegisterEntity(
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "LastName")
    val lastName: String,
    @ColumnInfo(name = "EmailLogin")
    val emailLogin: String,
    @ColumnInfo(name = "Password")
    val password: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userID")
    var userId: Int = 0
}
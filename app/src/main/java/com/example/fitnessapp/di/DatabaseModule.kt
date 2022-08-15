package com.example.fitnessapp.di

import android.content.Context
import androidx.room.Room
import com.example.fitnessapp.data.repository.Database
import com.example.fitnessapp.data.repository.RegisterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        Database::class.java,
        "database"
    ).build()

    @Provides
    @Singleton
    fun provideDatabaseDao(db: Database): RegisterDao {
        return db.RegisterDao()
    }
}
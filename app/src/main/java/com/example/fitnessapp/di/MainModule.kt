package com.example.fitnessapp.di

import android.content.Context
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.use_cases.register_validation.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)

    @Provides
    @Singleton
    fun provideEmailUseCase() = EmailValidation()
    @Provides
    @Singleton
    fun provideLastNameUseCase() = LastNameValidation()
    @Provides
    @Singleton
    fun provideNameUseCase() = NameValidation()
    @Provides
    @Singleton
    fun providePasswordUseCase() = PasswordValidation()
    @Provides
    @Singleton
    fun provideTermUseCase() = TermValidation()

}
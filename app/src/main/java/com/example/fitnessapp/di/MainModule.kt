package com.example.fitnessapp.di

import android.content.Context
import com.example.fitnessapp.data.DataStoreRepository
import com.example.fitnessapp.data.repository.RoomRepository
import com.example.fitnessapp.use_cases.login.CheckUserEmailCredentials
import com.example.fitnessapp.use_cases.login.CheckUserPasswordCredentials
import com.example.fitnessapp.use_cases.login.LoginUseCases
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
    fun provideRegisterUseCases(repository: RoomRepository) = RegisterUseCases(
        emailValidation = EmailValidation(),
        lastNameValidation = LastNameValidation(),
        nameValidation = NameValidation(),
        passwordValidation = PasswordValidation(),
        termValidation = TermValidation(),
        checkIfEmailExist = CheckIfEmailExist(repository = repository)
    )

    @Provides
    @Singleton
    fun provideLoginUseCases(repository: RoomRepository) = LoginUseCases(
        checkUserEmailCredentials = CheckUserEmailCredentials(repository = repository),
        checkUserPasswordCredentials = CheckUserPasswordCredentials(repository = repository)
    )
}
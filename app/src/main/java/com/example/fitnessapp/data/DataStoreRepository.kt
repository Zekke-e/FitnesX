package com.example.fitnessapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class DataStoreRepository(context: Context) {
    private object PreferencesKey {
        val onBoardingKey = intPreferencesKey(name = "on_boarding_completed")
    }

    private val dataStore = context.dataStore
    suspend fun saveOnBoardingState(completed: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    fun readOnBoardingState(): Flow<Int> {
        return dataStore.data
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: 0
                onBoardingState
            }
    }
}
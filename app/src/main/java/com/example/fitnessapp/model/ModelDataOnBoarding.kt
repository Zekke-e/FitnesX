package com.example.fitnessapp.model

data class ModelDataOnBoarding(
    private var image: Int,
    private var title: String,
    private var description: String,
    private var progress: Int
) {
    fun getImage(): Int {
        return image
    }

    fun getTitle(): String {
        return title
    }

    fun getDescription(): String {
        return description
    }

    fun getProgress(): Int {
        return progress
    }
}
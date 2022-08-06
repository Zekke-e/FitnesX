package com.example.fitnessapp.navigation

import com.example.fitnessapp.R

sealed class Screen(val route: Int) {
    object OnBoarding : Screen(route = R.id.onBoardingScreen)
    object Register : Screen(route = R.id.registerScreen)
    object Login : Screen(route = R.id.loginScreen)
    object RegisterProfile : Screen(route = R.id.registerProfileDetails)
    object RegisterPageGoal : Screen(route = R.id.registerPageGoal)
}
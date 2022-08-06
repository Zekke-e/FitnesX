package com.example.fitnessapp.data

import com.example.fitnessapp.R
import com.example.fitnessapp.model.ModelDataOnBoarding

class OnboardingData {
    companion object {
        fun onBonardingScreens(): ArrayList<ModelDataOnBoarding> {
            val onBoardingScreens = ArrayList<ModelDataOnBoarding>()
            val screen1 = ModelDataOnBoarding(
                R.drawable.first_page,
                "Track Your Goals",
                "Don't worry if you have trouble determining your goals, We can help you determine your goals and track your goals",
                33
            )
            val screen2 = ModelDataOnBoarding(
                R.drawable.second_page,
                "Get Burn",
                "Let’s keep burning, to achive yours goals, it hurts only temporarily, if you give up now you will be in pain forever",
                66
            )
            val screen3 = ModelDataOnBoarding(
                R.drawable.third_page,
                "Improve Sleep\nQuality",
                "Improve the quality of your sleep with us, good quality sleep can bring a good mood in the morning",
                100
            )

            onBoardingScreens.add(screen1)
            onBoardingScreens.add(screen2)
            onBoardingScreens.add(screen3)
            return onBoardingScreens
        }
    }
}
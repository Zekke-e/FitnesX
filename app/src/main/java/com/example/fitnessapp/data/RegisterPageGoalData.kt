package com.example.fitnessapp.data

import com.example.fitnessapp.R
import com.example.fitnessapp.model.ModelRegisterPageGoal

class RegisterPageGoalData {

    companion object {
        fun getRegisterPageGoalData(): ArrayList<ModelRegisterPageGoal> {
            val registerPagesDetail = ArrayList<ModelRegisterPageGoal>()

            val screen1 = ModelRegisterPageGoal(
                R.drawable.run,
                "Improve Shape",
                "I have a low amount of body fat and need / want to build more muscle"
            )
            val screen2 = ModelRegisterPageGoal(
                R.drawable.jump,
                "Lean & Tone",
                "I’m “skinny fat”. look thin but have no shape. I want to add learn muscle in the right way"
            )
            val screen3 = ModelRegisterPageGoal(
                R.drawable.pull,
                "Lose a Fat",
                "I have over 20 lbs to lose. I want to drop all this fat and gain muscle mass"
            )

            registerPagesDetail.add(screen1)
            registerPagesDetail.add(screen2)
            registerPagesDetail.add(screen3)

            return registerPagesDetail
        }
    }
}
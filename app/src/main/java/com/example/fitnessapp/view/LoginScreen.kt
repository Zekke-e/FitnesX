package com.example.fitnessapp.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R

class LoginScreen : Fragment(R.layout.fragment_login_screen) {
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textView8)

        textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }

    }
}
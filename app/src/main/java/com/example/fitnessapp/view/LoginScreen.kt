package com.example.fitnessapp.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.fragment_login_screen) {
    private lateinit var textView: TextView
    private lateinit var button: Button

    private val registerViewModel: RegisterViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textView8)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) { println("db:${registerViewModel.getUser(1)}") }
        }
        textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }

    }
}
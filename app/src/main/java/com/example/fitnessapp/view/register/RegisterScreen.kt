package com.example.fitnessapp.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentRegisterScreenBinding

class RegisterScreen : Fragment(R.layout.fragment_register_screen) {

    private var _binding: FragmentRegisterScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegisterScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_registerScreen_to_registerProfileDetails)
        }
        binding.textView8.setOnClickListener {
            findNavController().navigate(R.id.action_registerScreen_to_loginScreen)
        }
    }
}
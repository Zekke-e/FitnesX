package com.example.fitnessapp.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitnessapp.databinding.FragmentRegisterFinalBinding

class RegisterFinalPage : Fragment() {

    private var _binding: FragmentRegisterFinalBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterFinalBinding.inflate(inflater)
        return binding.root
    }
}
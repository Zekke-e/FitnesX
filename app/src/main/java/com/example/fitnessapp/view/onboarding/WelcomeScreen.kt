package com.example.fitnessapp.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.fitnessapp.databinding.FragmentWelcomeScreenBinding
import com.example.fitnessapp.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WelcomeScreen : Fragment() {

    private val viewModel: SplashViewModel by viewModels()
    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(viewModel.startDestination.value!!, null, navOptions {
                anim {
                    enter = com.example.fitnessapp.R.anim.slide_left
                    exit = com.example.fitnessapp.R.anim.wait_delay
                    popEnter = com.example.fitnessapp.R.anim.wait_delay
                    popExit = com.example.fitnessapp.R.anim.slide_right
                }
            })
        }
    }
}
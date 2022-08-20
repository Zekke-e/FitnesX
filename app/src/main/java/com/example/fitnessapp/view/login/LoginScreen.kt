package com.example.fitnessapp.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentLoginScreenBinding
import com.example.fitnessapp.util.showSnackBar
import com.example.fitnessapp.view.home.HomeActivity
import com.example.fitnessapp.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreen : Fragment() {

    private var _binding: FragmentLoginScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginScreenBinding.inflate(inflater)
        return binding.root
    }

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            loginViewModel.loginUser(
                userEmail = binding.email.text.toString(),
                password = binding.password.text.toString()
            )
            lifecycleScope.launchWhenStarted {
                loginViewModel.loginUiState.collect { loginStates ->
                    when (loginStates) {
                        is LoginStates.Loading -> {
                            println("Loading!")
                            binding.progressBar.isVisible = true
                        }
                        is LoginStates.Success -> {
                            showSnackBar(binding.root, "Success log in")
                            loginViewModel.saveUserLoginState(1)
                            binding.progressBar.isVisible = false
                            val intent = HomeActivity.newIntent(requireContext())
                            startActivity(intent)
                            activity?.finish()
                        }
                        is LoginStates.Error -> {
                            showSnackBar(binding.root, loginStates.message)
                            binding.progressBar.isVisible = false
                        }
                        else -> Unit
                    }
                }
            }
        }

        binding.textView8.setOnClickListener()
        {
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
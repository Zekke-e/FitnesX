package com.example.fitnessapp.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentRegisterScreenBinding
import com.example.fitnessapp.use_cases.RegisterFormEvent
import com.example.fitnessapp.use_cases.register_validation.TermValidation
import com.example.fitnessapp.util.onTextChanged
import com.example.fitnessapp.viewmodel.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterScreen : Fragment() {

    private var _binding: FragmentRegisterScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WelcomeViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegisterScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.validationEvents.collect { event ->
                when (event) {
                    is WelcomeViewModel.ValidationEvent.Success -> {
                        Toast.makeText(requireContext(), "asd", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.name.onTextChanged {
            viewModel.onEvent(RegisterFormEvent.NameChanged(it))
        }
        binding.lastName.onTextChanged {
            viewModel.onEvent(RegisterFormEvent.LastNameChanged(it))
        }
        binding.email.onTextChanged {
            viewModel.onEvent(RegisterFormEvent.EmailChanged(it))
        }
        binding.password.onTextChanged {
            viewModel.onEvent(RegisterFormEvent.PasswordChanged(it))
        }
        binding.termAccept.setOnCheckedChangeListener{ _, isChecked ->
            viewModel.onEvent(RegisterFormEvent.TermChanged(isChecked))
        }

        binding.button.setOnClickListener {
            viewModel.onEvent(RegisterFormEvent.Submit)
            binding.textInputLayout.error = viewModel.state.nameError
            binding.textInputLayout2.error = viewModel.state.lastNameError
            binding.textInputLayout3.error = viewModel.state.emailError
            binding.textInputLayout4.error = viewModel.state.passwordError
            binding.termAccept.error = viewModel.state.termAcceptError


//            findNavController().navigate(R.id.action_registerScreen_to_registerProfileDetails)
        }
        binding.textView8.setOnClickListener {
            findNavController().navigate(R.id.action_registerScreen_to_loginScreen)
        }
    }
}
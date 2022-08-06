package com.example.fitnessapp.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentRegisterProfileBinding

class RegisterProfileDetails : Fragment() {
    private lateinit var adapterItems: ArrayAdapter<String>
    private var _binding: FragmentRegisterProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterItems = ArrayAdapter(requireContext(), R.layout.list_item, resources.getStringArray(R.array.genders))
        binding.genderType.setAdapter(adapterItems)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_registerProfileDetails_to_registerPageGoal)
        }
    }
}
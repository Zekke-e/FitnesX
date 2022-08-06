package com.example.fitnessapp.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.data.OnboardingData
import com.example.fitnessapp.databinding.FragmentOnBoardingPageBinding
import com.example.fitnessapp.model.ModelDataOnBoarding
import com.example.fitnessapp.viewmodel.WelcomeViewModel

class OnBoardingScreen : Fragment() {
    private var _binding: FragmentOnBoardingPageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WelcomeViewModel by activityViewModels()
    private lateinit var runAdapter: AdapterOnBoarding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentOnBoardingPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = OnboardingData.onBonardingScreens()
        setupViewPager2(data)
    }

    private fun setupViewPager2(data: ArrayList<ModelDataOnBoarding>) = binding.viewPager.apply {
        runAdapter =
            AdapterOnBoarding(data) {
                findNavController().navigate(R.id.action_onBoardingScreen_to_loginScreen).apply {
                    viewModel.saveOnBoardingState(1)
                }
            }
        adapter = runAdapter
        binding.circleIndicator3.setViewPager(binding.viewPager)
    }


}
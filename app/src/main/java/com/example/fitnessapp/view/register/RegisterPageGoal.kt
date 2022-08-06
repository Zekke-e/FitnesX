package com.example.fitnessapp.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.fitnessapp.R
import com.example.fitnessapp.data.RegisterPageGoalData
import com.example.fitnessapp.databinding.FragmentRegisterPageGoalBinding
import com.example.fitnessapp.model.ModelRegisterPageGoal
import kotlin.math.abs

class RegisterPageGoal : Fragment() {

    private var _binding: FragmentRegisterPageGoalBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterPageGoal: AdapterRegisterPageGoal

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterPageGoalBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = RegisterPageGoalData.getRegisterPageGoalData()
        setupViewPager2(data)
        binding.viewPagerGoal.post {
            binding.viewPagerGoal.setCurrentItem(1, true)
        }
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_registerPageGoal_to_registerFinalPage)
        }
    }

    private fun setupViewPager2(data: ArrayList<ModelRegisterPageGoal>) = binding.viewPagerGoal.apply {
        adapterPageGoal = AdapterRegisterPageGoal(data)
        adapter = adapterPageGoal
        clipToPadding = false
        clipChildren = false
        offscreenPageLimit = 3
        getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val pages = CompositePageTransformer()
        pages.addTransformer(MarginPageTransformer(50))
        pages.addTransformer { page, position ->
            val x: Float = 1 - abs(position)
            page.scaleY = (0.85f + x * 0.15f)
        }
        setPageTransformer(pages)
    }
}
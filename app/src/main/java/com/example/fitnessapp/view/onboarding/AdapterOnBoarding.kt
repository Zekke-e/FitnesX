package com.example.fitnessapp.view.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemViewPagerBinding
import com.example.fitnessapp.model.ModelDataOnBoarding
import com.example.fitnessapp.util.loadIntoImageView

class AdapterOnBoarding(
    private val onBoardingScreenDetails: ArrayList<ModelDataOnBoarding>,
    private val savePosition: (Int) -> Unit
) : RecyclerView.Adapter<AdapterOnBoarding.ViewPagerViewHolder>() {
    class ViewPagerViewHolder(val binding: ItemViewPagerBinding, clickPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.progressBar.setOnClickListener {
                clickPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(view) {
            savePosition(onBoardingScreenDetails[it].getProgress())
        }
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = onBoardingScreenDetails[position].getImage()
        val curDescription = onBoardingScreenDetails[position].getDescription()
        val curTitle = onBoardingScreenDetails[position].getTitle()
//        holder.binding.ivImage.load(curImage)
        loadIntoImageView(curImage, holder.binding.ivImage)
        holder.binding.textView2.text = curDescription
        holder.binding.textView.text = curTitle
        when (position) {
            2 -> holder.binding.finish.visibility = View.VISIBLE
            else -> holder.binding.finish.visibility = View.GONE
        }
    }


    override fun getItemCount(): Int {
        return onBoardingScreenDetails.size
    }
}
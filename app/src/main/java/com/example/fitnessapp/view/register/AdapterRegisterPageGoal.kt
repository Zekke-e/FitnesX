package com.example.fitnessapp.view.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemViewPagerGoalBinding
import com.example.fitnessapp.model.ModelRegisterPageGoal

class AdapterRegisterPageGoal(
    private val registerPages: ArrayList<ModelRegisterPageGoal>,
) : RecyclerView.Adapter<AdapterRegisterPageGoal.ViewPagerRegisterViewHolder>() {

    class ViewPagerRegisterViewHolder(val binding: ItemViewPagerGoalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerRegisterViewHolder {
        return ViewPagerRegisterViewHolder(
            ItemViewPagerGoalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewPagerRegisterViewHolder, position: Int) {
        val curImage = registerPages[position].getImage()
        val curDescription = registerPages[position].getDescription()
        val curTitle = registerPages[position].getTitle()
        holder.binding.imageView.setImageResource(curImage)
        holder.binding.title.text = curTitle
        holder.binding.description.text = curDescription
    }

    override fun getItemCount(): Int {
        return registerPages.size
    }
}

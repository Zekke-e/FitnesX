package com.example.fitnessapp.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import coil.api.load
import coil.request.CachePolicy
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

fun loadIntoImageView(imageResource: Int, image: ImageView) {
    val shimmer = Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
        .setDuration(1000) // how long the shimmering animation takes to do one full sweep
        .setBaseAlpha(0.7f) //the alpha of the underlying children
        .setHighlightAlpha(0.6f) // the shimmer alpha amount
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()

// This is the placeholder for the imageView
    val shimmerDrawable = ShimmerDrawable().apply {
        setShimmer(shimmer)

    }
    image.load(imageResource) {
        crossfade(true)
        diskCachePolicy(CachePolicy.ENABLED)
//        placeholder(shimmerDrawable)
        //        build()
    }
}

fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged.invoke(s.toString())
        }
        override fun afterTextChanged(editable: Editable?) = Unit
    })
}
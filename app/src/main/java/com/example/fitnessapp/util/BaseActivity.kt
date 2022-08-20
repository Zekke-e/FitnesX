package com.example.fitnessapp.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.api.load
import coil.request.CachePolicy
import com.google.android.material.snackbar.Snackbar

fun loadIntoImageView(imageResource: Int, image: ImageView) {
    image.load(imageResource) {
        crossfade(true)
        diskCachePolicy(CachePolicy.ENABLED)
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

fun Fragment.showSnackBar(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}
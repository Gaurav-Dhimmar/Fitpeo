package com.myapplication.app.main.ui.home.binding_adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.myapplication.app.utils.getParentActivity
import com.squareup.picasso.Picasso

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, thumbnailUrl: String) {
    Picasso.get().load(thumbnailUrl).into(imageView)
}

@BindingAdapter("setImageTitle")
fun setImageTitle(textView: TextView, title: String) {
    textView.text = title
    textView.isSelected = true
}
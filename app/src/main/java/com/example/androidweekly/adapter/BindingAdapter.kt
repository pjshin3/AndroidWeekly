package com.example.androidweekly.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("imageFromUrl")
fun bindingImageUrl(view : ImageView, imageUrl: String?){
    if (!imageUrl.isNullOrEmpty()){
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("isGone")
fun bindingViewIsGone(view: View, isGone: Boolean){
    view.visibility = if (isGone){
        View.GONE
    }else{
        View.VISIBLE
    }
}
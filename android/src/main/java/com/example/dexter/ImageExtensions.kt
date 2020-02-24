package com.example.dexter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

fun ImageView.loadUrl(url: String, transformation: BitmapTransformation? = null) {
    val builder = Glide.with(this).load(url)
    transformation?.let { builder.transform(it) }
    builder.into(this)
}

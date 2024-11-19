package com.example.webandcrafttest.data.model

import com.google.gson.annotations.SerializedName

data class SubCategory(
    val title: String,
    @SerializedName("image_url")
    val imageUrl: String
)
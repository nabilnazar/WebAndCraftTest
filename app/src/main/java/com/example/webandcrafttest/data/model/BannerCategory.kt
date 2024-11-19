package com.example.webandcrafttest.data.model

import com.google.gson.annotations.SerializedName


data class BannerCategory(
    val contents: List<SubCategory>,
    val id: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val title: String,
    val type: String
)
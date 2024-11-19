package com.example.webandcrafttest.data.model

import com.google.gson.annotations.SerializedName


data class ProductCategory(
    val contents: List<Product>,
    val id: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val title: String,
    val type: String
)
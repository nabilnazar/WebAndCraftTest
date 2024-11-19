package com.example.webandcrafttest.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("actual_price")
    val actualPrice: String,
    val discount: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("offer_price")
    val offerPrice: String?,
    @SerializedName("product_image")
    val productImage: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_rating")
    val productRating: Int,
    val sku: String,
    val title: String,
)
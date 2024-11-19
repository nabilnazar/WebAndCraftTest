package com.example.webandcrafttest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products",primaryKeys = ["sku", "type"])
data class ProductEntity(
    val sku: String,            // Unique SKU for each product
    val actualPrice: String?,
    val discount: String?,
    val imageUrl: String?,
    val offerPrice: String?,
    val productName: String?,
    val productRating: Int,
    val title: String?,
    val type: String,                      // "Best Sellers" or "Most Popular"
    val categoryId: String?
)
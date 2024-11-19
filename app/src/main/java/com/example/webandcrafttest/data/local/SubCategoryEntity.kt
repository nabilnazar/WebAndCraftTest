package com.example.webandcrafttest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "subcategories")
data class SubCategoryEntity(
    @PrimaryKey val title: String,
    val imageUrl: String?,
    val type: String?
)

package com.example.webandcrafttest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webandcrafttest.data.local.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<ProductEntity>)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE type = :type")
    suspend fun getProductsByType(type: String): List<ProductEntity>
}
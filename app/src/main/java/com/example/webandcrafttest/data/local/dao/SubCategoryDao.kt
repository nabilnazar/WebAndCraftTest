package com.example.webandcrafttest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webandcrafttest.data.local.SubCategoryEntity

@Dao
interface SubCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(subcategories: List<SubCategoryEntity>)

    @Query("SELECT * FROM subcategories WHERE type = :type")
    suspend fun getSubCategoriesByType(type: String): List<SubCategoryEntity>
}
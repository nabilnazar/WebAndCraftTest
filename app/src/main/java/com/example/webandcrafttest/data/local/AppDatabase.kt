package com.example.webandcrafttest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.webandcrafttest.data.local.dao.ProductDao
import com.example.webandcrafttest.data.local.dao.SubCategoryDao

@Database(entities = [ProductEntity::class, SubCategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun subCategoryDao(): SubCategoryDao
}
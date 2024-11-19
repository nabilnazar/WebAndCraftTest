package com.example.webandcrafttest.domain.repository

import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.data.model.BannerCategoryListResponse
import com.example.webandcrafttest.data.model.ProductCategoryListResponse

interface CategoryRepository {

    //network operations
    suspend fun fetchAllBannerCategories(): BannerCategoryListResponse
    suspend fun fetchAllProductCategories(): ProductCategoryListResponse


    // Database Operations
    suspend fun saveProductsToDb(products: List<ProductEntity>)
    suspend fun saveSubCategoriesToDb(subCategories: List<SubCategoryEntity>)
    suspend fun getProductsFromDb(): List<ProductEntity>


    // New methods to filter by type
    suspend fun getProductsByType(type: String): List<ProductEntity>
    suspend fun getSubCategoriesByType(type: String): List<SubCategoryEntity>
}
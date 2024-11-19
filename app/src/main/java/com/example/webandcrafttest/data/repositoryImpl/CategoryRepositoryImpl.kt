package com.example.webandcrafttest.data.repositoryImpl

import android.util.Log
import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.data.local.dao.ProductDao
import com.example.webandcrafttest.data.local.dao.SubCategoryDao
import com.example.webandcrafttest.data.model.BannerCategoryListResponse
import com.example.webandcrafttest.data.model.ProductCategoryListResponse
import com.example.webandcrafttest.data.remote.ApiService
import com.example.webandcrafttest.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val apiService: ApiService,
    private val productDao: ProductDao,
    private val subCategoryDao: SubCategoryDao
) : CategoryRepository {

    // Fetch Banner Categories from Network
    override suspend fun fetchAllBannerCategories(): BannerCategoryListResponse {
        return apiService.getAllBannerData()

    }

    // Fetch Product Categories from Network
    override suspend fun fetchAllProductCategories(): ProductCategoryListResponse {
        return apiService.getAllProductData()
    }

    // Database Operations
    override suspend fun saveProductsToDb(products: List<ProductEntity>) {
        productDao.insertAll(products)
    }

    override suspend fun saveSubCategoriesToDb(subCategories: List<SubCategoryEntity>) {
        subCategoryDao.insertAll(subCategories)
    }

    override suspend fun getProductsFromDb(): List<ProductEntity> {
        return productDao.getAllProducts()
    }


    // New methods to filter by type
    override suspend fun getProductsByType(type: String): List<ProductEntity> {
        return productDao.getProductsByType(type)
    }

    override suspend fun getSubCategoriesByType(type: String): List<SubCategoryEntity> {
        return subCategoryDao.getSubCategoriesByType(type)
    }
}

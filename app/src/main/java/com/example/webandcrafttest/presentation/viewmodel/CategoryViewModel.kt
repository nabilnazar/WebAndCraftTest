package com.example.webandcrafttest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.data.model.Product
import com.example.webandcrafttest.data.model.SubCategory
import com.example.webandcrafttest.domain.usecases.FetchBannersCategoriesUseCase
import com.example.webandcrafttest.domain.usecases.FetchProductCategoriesUseCase
import com.example.webandcrafttest.domain.usecases.GetProductsByTypeUseCase
import com.example.webandcrafttest.domain.usecases.GetProductsFromDbUseCase
import com.example.webandcrafttest.domain.usecases.GetSubCategoriesByTypeUseCase
import com.example.webandcrafttest.domain.usecases.SaveProductsToDbUseCase
import com.example.webandcrafttest.domain.usecases.SaveSubCategoriesToDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val fetchBannersCategoriesUseCase: FetchBannersCategoriesUseCase,
    private val fetchProductCategoriesUseCase: FetchProductCategoriesUseCase,
    private val saveProductsToDbUseCase: SaveProductsToDbUseCase,
    private val getProductsByTypeUseCase: GetProductsByTypeUseCase,
    private val getSubCategoriesByTypeUseCase: GetSubCategoriesByTypeUseCase,
    private val saveSubCategoriesToDbUseCase: SaveSubCategoriesToDbUseCase,
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase
) : ViewModel() {

    private val _bestSellers = MutableStateFlow<List<Product>>(emptyList())
    val bestSellers: StateFlow<List<Product>> get() = _bestSellers

    private val _topCategories = MutableStateFlow<List<SubCategory>>(emptyList())
    val topCategories: StateFlow<List<SubCategory>> get() = _topCategories

    private val _mostPopular = MutableStateFlow<List<Product>>(emptyList())
    val mostPopular: StateFlow<List<Product>> get() = _mostPopular

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            loadProducts()
            loadCategories()
        }
    }

    private suspend fun loadCategories() {
        val cachedTopCategory = getSubCategoriesByTypeUseCase("catagories")

        if (cachedTopCategory.isNotEmpty()) {
            _topCategories.value = cachedTopCategory.map { it.toSubCategory() }
        } else {
            try {
                val topCategoryResponse = fetchBannersCategoriesUseCase()
                val subCategoryEntity = mutableListOf<SubCategoryEntity>()

                topCategoryResponse.forEach { bannerCategory ->

                    if (bannerCategory.type == "catagories"){
                        subCategoryEntity.addAll(
                            bannerCategory.contents.map {
                                SubCategoryEntity(
                                    title = it.title,
                                    imageUrl = it.imageUrl,
                                    type =  bannerCategory.type
                                )
                            }
                        )
                    }
                }
                if(subCategoryEntity.isNotEmpty()){
                    saveSubCategoriesToDbUseCase(subCategoryEntity)
                }

                _topCategories.value = subCategoryEntity
                    .filter { it.type == "catagories" }
                    .map { it.toSubCategory() }
                    .toList()

            } catch (e: Exception) {
                // Handle error (e.g., log it)
            }
        }
    }

    private suspend fun loadProducts() {
        // Check if data exists in DB for Best Sellers
        val cachedBestSellers = getProductsByTypeUseCase("Best Sellers")
        val cachedMostPopular = getProductsByTypeUseCase("Most Popular")

        // If cached data is available, update the UI with it
        if (cachedBestSellers.isNotEmpty() && cachedMostPopular.isNotEmpty()) {
            _bestSellers.value = cachedBestSellers.map { it.toProduct() }
            _mostPopular.value = cachedMostPopular.map { it.toProduct() }
        } else {
            // If no cached data, fetch from API and save to DB
            try {
                val productCategoryResponse = fetchProductCategoriesUseCase()

                // Transform API response to ProductEntity list
                val productEntities = mutableListOf<ProductEntity>()
                productCategoryResponse.forEach { category ->
                    if (category.type == "products") {
                        productEntities.addAll(
                            category.contents.map { product ->
                                ProductEntity(
                                    sku = product.sku,
                                    actualPrice = product.actualPrice,
                                    discount = product.discount,
                                    imageUrl = product.imageUrl,
                                    offerPrice = product.offerPrice,
                                    productName = product.productName,
                                    productRating = product.productRating,
                                    title = product.title,
                                    type = category.title,  // "Best Sellers" or "Most Popular"
                                    categoryId = category.id
                                )
                            }
                        )
                    }
                }

                // **Save products to DB only if the DB is empty**
                if (productEntities.isNotEmpty()) {
                    saveProductsToDbUseCase(productEntities)
                }

                // Update UI state with newly fetched data
                _bestSellers.value = productEntities
                    .filter { it.type == "Best Sellers" }
                    .map { it.toProduct() }
                    .toList()

                _mostPopular.value = productEntities
                    .filter { it.type == "Most Popular" }
                    .map { it.toProduct() }
                    .toList()

            } catch (e: Exception) {
                // Handle error (e.g., log it)
            }
        }
    }

    // Extension function to convert ProductEntity to Product
    private fun ProductEntity.toProduct(): Product {
        return Product(
            actualPrice = this.actualPrice ?: "",
            discount = this.discount ?: "",
            imageUrl = this.imageUrl ?: "",
            offerPrice = this.offerPrice,
            productImage = this.imageUrl ?: "", // Adjust as needed
            productName = this.productName ?: "",
            productRating = this.productRating,
            sku = this.sku,
            title = this.title ?: ""
        )
    }


    private fun SubCategoryEntity.toSubCategory(): SubCategory {
        return SubCategory(
            title = this.title,
            imageUrl = this.imageUrl ?: ""
        )
    }
}
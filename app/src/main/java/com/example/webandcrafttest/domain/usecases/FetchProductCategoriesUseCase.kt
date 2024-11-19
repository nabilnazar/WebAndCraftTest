package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.model.ProductCategoryListResponse
import com.example.webandcrafttest.domain.repository.CategoryRepository

class FetchProductCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): ProductCategoryListResponse {
        return categoryRepository.fetchAllProductCategories()
    }
}
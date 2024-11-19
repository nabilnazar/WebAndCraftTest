package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.model.BannerCategoryListResponse
import com.example.webandcrafttest.domain.repository.CategoryRepository

class FetchBannersCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): BannerCategoryListResponse {
        return categoryRepository.fetchAllBannerCategories()
    }
}
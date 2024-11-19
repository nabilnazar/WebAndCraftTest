package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.domain.repository.CategoryRepository

class GetSubCategoriesByTypeUseCase(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(type: String): List<SubCategoryEntity> {
        return repository.getSubCategoriesByType(type)
    }
}
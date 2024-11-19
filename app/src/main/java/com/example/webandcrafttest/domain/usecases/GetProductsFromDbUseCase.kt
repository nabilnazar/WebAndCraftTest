package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.domain.repository.CategoryRepository

class GetProductsFromDbUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): List<ProductEntity> {
        return categoryRepository.getProductsFromDb()
    }
}
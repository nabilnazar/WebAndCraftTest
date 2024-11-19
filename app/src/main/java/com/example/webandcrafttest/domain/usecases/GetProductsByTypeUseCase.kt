package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.domain.repository.CategoryRepository

class GetProductsByTypeUseCase(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(type: String): List<ProductEntity> {
        return repository.getProductsByType(type)
    }
}

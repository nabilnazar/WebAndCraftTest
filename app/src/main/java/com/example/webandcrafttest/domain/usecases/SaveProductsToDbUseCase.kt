package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.local.ProductEntity
import com.example.webandcrafttest.domain.repository.CategoryRepository


class SaveProductsToDbUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(products: List<ProductEntity>) {
        categoryRepository.saveProductsToDb(products)
    }
}
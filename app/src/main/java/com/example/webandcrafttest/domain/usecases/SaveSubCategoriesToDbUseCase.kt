package com.example.webandcrafttest.domain.usecases

import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.domain.repository.CategoryRepository

class SaveSubCategoriesToDbUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(subCategories: List<SubCategoryEntity>) {
        categoryRepository.saveSubCategoriesToDb(subCategories)
    }
}
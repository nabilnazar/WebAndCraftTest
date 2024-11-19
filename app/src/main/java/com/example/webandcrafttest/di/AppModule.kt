package com.example.webandcrafttest.di

import android.content.Context
import androidx.room.Room
import com.example.webandcrafttest.data.local.AppDatabase
import com.example.webandcrafttest.data.local.dao.ProductDao
import com.example.webandcrafttest.data.local.dao.SubCategoryDao
import com.example.webandcrafttest.data.remote.ApiService
import com.example.webandcrafttest.data.repositoryImpl.CategoryRepositoryImpl
import com.example.webandcrafttest.domain.repository.CategoryRepository
import com.example.webandcrafttest.domain.usecases.FetchBannersCategoriesUseCase
import com.example.webandcrafttest.domain.usecases.FetchProductCategoriesUseCase
import com.example.webandcrafttest.domain.usecases.GetProductsByTypeUseCase
import com.example.webandcrafttest.domain.usecases.GetProductsFromDbUseCase
import com.example.webandcrafttest.domain.usecases.GetSubCategoriesByTypeUseCase
import com.example.webandcrafttest.domain.usecases.SaveProductsToDbUseCase
import com.example.webandcrafttest.domain.usecases.SaveSubCategoriesToDbUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://64bfc2a60d8e251fd111630f.mockapi.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "webandcraft_database"
        ).build()
    }

    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }

    @Provides
    fun provideSubCategoryDao(appDatabase: AppDatabase): SubCategoryDao {
        return appDatabase.subCategoryDao()
    }



    @Provides
    @Singleton
    fun provideCategoryRepository(
        apiService: ApiService,
        productDao: ProductDao,
        subCategoryDao: SubCategoryDao
    ): CategoryRepository {
        return CategoryRepositoryImpl(apiService, productDao, subCategoryDao)
    }

    @Provides
    @Singleton
    fun provideFetchBannersCategoriesUseCase(repository: CategoryRepository): FetchBannersCategoriesUseCase {
        return FetchBannersCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideFetchProductCategoriesUseCase(repository: CategoryRepository): FetchProductCategoriesUseCase {
        return FetchProductCategoriesUseCase(repository)
    }

    @Provides
    fun provideSaveProductsToDbUseCase(repository: CategoryRepository): SaveProductsToDbUseCase {
        return SaveProductsToDbUseCase(repository)
    }

    @Provides
    fun provideGetProductsFromDbUseCase(repository: CategoryRepository): GetProductsFromDbUseCase {
        return GetProductsFromDbUseCase(repository)
    }

    @Provides
    fun provideSaveSubCategoriesToDbUseCase(repository: CategoryRepository): SaveSubCategoriesToDbUseCase {
        return SaveSubCategoriesToDbUseCase(repository)
    }



    @Provides
    fun provideGetProductsByTypeUseCase(repository: CategoryRepository): GetProductsByTypeUseCase {
        return GetProductsByTypeUseCase(repository)
    }

    @Provides
    fun provideGetSubCategoriesByTypeUseCase(repository: CategoryRepository): GetSubCategoriesByTypeUseCase {
        return GetSubCategoriesByTypeUseCase(repository)
    }


}
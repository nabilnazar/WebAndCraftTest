package com.example.webandcrafttest.data.remote

import com.example.webandcrafttest.data.model.BannerCategoryListResponse
import com.example.webandcrafttest.data.model.ProductCategoryListResponse
import retrofit2.http.GET

interface ApiService  {
    @GET("Todo")
    suspend fun getAllBannerData(): BannerCategoryListResponse

    @GET("Todo")
    suspend fun getAllProductData(): ProductCategoryListResponse

}
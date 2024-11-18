package com.prg.imagefactory.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.prg.imagefactory.data.remote.UnsplashAPIService
import com.prg.imagefactory.data.util.Constants
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object AppModule {
    val contentType = "application/json".toMediaType()
    val json = Json { ignoreUnknownKeys = true}
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(contentType))
        .baseUrl(Constants.BASE_URL)
        .build()

    val retrofitService: UnsplashAPIService by lazy {
        retrofit.create(UnsplashAPIService::class.java)
    }


}
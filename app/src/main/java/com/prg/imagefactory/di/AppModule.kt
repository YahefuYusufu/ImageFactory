package com.prg.imagefactory.di

import com.prg.imagefactory.data.remote.UnsplashAPIService
import com.prg.imagefactory.data.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object AppModule {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    val retrofitService: UnsplashAPIService by lazy {
        retrofit.create(UnsplashAPIService::class.java)
    }


}
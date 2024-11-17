package com.prg.imagefactory.data.remote

import com.prg.imagefactory.data.util.Constants.API_KEY
import retrofit2.http.GET

import retrofit2.http.Headers

interface UnsplashAPIService {


    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getEditorialFeedImages(): String

}
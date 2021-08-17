package com.example.homedeepottest.networking

import com.example.homedeepottest.model.JsonData
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("data.json")
    suspend fun getJson(): Response<JsonData>
}
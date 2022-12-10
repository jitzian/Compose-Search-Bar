package com.example.rocketgiant.data.remote

import com.example.rocketgiant.data.remote.model.ResultApi
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RestApi {
    @GET("games/")
    suspend fun fetchGames(@QueryMap queryMap: Map<String, String>): ResultApi
}
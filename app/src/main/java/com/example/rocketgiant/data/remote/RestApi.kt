package com.example.rocketgiant.data.remote

import com.example.rocketgiant.data.remote.model.ResulApiSingleGame
import com.example.rocketgiant.data.remote.model.ResultApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RestApi {
    @GET("games/")
    suspend fun fetchGames(@QueryMap queryMap: Map<String, String>): ResultApi

    @GET("game/{id}/?")
    suspend fun fetchGameDetailsById(
        @Path("id") id: String,
        @QueryMap queryMap: Map<String, String>
    ): ResulApiSingleGame
}
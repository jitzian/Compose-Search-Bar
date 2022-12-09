package com.example.rocketgiant.data.remote

import com.example.rocketgiant.data.remote.model.ResultApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RestApi {

    //https://www.giantbomb.com/api/games/?api_key=[API_KEY]&filter=name:[GAME_NAME]&format=json
    /*@GET("/games/?api_key=9d45436f87d3848d2bdcce810bacb6df57dfd134&filter=name:{gameName}&format=json")
    suspend fun fetchGames(@Path("gameName")gameName: String): ResultApi*/

    @GET("games/")
    suspend fun fetchGames(@QueryMap queryMap: Map<String, String>): ResultApi

}
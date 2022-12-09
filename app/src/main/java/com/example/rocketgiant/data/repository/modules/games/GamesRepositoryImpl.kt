package com.example.rocketgiant.data.repository.modules.games

import com.example.rocketgiant.data.remote.RestApi
import com.example.rocketgiant.data.remote.model.ResultApi
import com.example.rocketgiant.domain.repository.games.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val restApi: RestApi): GamesRepository {
    override suspend fun fetchGames(gameName: String): ResultApi {
        //return restApi.fetchGames(gameName)
        //https://www.giantbomb.com/api/games/?api_key=9d45436f87d3848d2bdcce810bacb6df57dfd134&filter=name:SEGA&format=json
        return restApi.fetchGames(
            mapOf(
                "api_key" to "9d45436f87d3848d2bdcce810bacb6df57dfd134",
                "filter=name" to gameName,
                "format" to "json"
            )
        )
    }
}
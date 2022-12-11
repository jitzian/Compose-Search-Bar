package com.example.rocketgiant.data.repository.modules.games

import com.example.rocketgiant.constants.GlobalConstants.Companion.API_KEY
import com.example.rocketgiant.data.remote.RestApi
import com.example.rocketgiant.data.remote.model.ResulApiSingleGame
import com.example.rocketgiant.data.remote.model.ResultApi
import com.example.rocketgiant.domain.repository.games.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val restApi: RestApi) : GamesRepository {
    override suspend fun fetchGames(gameName: String): ResultApi {
        return restApi.fetchGames(
            mapOf(
                "api_key" to API_KEY,
                "filter" to "name:$gameName",
                "format" to "json"
            )
        )
    }

    override suspend fun fetchGameDetailsById(id: Int): ResulApiSingleGame {
        return restApi.fetchGameDetailsById(
            id = id.toString(),
            mapOf(
                "api_key" to API_KEY,
                "format" to "json"
            )
        )
    }
}
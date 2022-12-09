package com.example.rocketgiant.domain.repository.games

import com.example.rocketgiant.data.remote.model.ResultApi

interface GamesRepository {
    suspend fun fetchGames(gameName: String): ResultApi
}
package com.example.rocketgiant.data.di.modules.games

import com.example.rocketgiant.data.repository.modules.games.GamesRepositoryImpl
import com.example.rocketgiant.domain.repository.games.GamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GamesRepositoryModule {
    @Binds
    @Singleton
    abstract fun gamesRepository(gamesRepository: GamesRepositoryImpl): GamesRepository
}
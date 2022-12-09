package com.example.rocketgiant.data.di.modules.network

import com.example.rocketgiant.constants.GlobalConstants
import com.example.rocketgiant.data.remote.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    //TODO: Check if interceptor is required..!!!
    @Provides
    @Singleton //Scope for instance
    fun providesApi(): RestApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GlobalConstants.baseUrl)
            .build()
            .create(RestApi::class.java)
    }

}
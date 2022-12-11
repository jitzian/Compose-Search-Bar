package com.example.rocketgiant.data.di.modules.network

import com.example.rocketgiant.BuildConfig
import com.example.rocketgiant.constants.GlobalConstants
import com.example.rocketgiant.data.remote.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton //Scope for instance
    fun providesApi(): RestApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(setupOkHttpClient())
            .baseUrl(GlobalConstants.baseUrl)
            .build()
            .create(RestApi::class.java)
    }

    //Setup OkHttp client and logger interceptor
    private fun setupOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpLoggingInterceptor.setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BASIC
            }
        )
        return httpClient.build()
    }

}
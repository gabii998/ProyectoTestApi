package com.ascurra.proyectotestapi.di

import com.ascurra.proyectotestapi.app.RetrofitClient
import com.ascurra.proyectotestapi.data.datasource.PokemonRemoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return RetrofitClient.getRetrofitService()
    }

    @Singleton
    @Provides
    fun getPokemonRemoteApi(retrofit: Retrofit):PokemonRemoteApi{
        return retrofit.create(PokemonRemoteApi::class.java)
    }

}
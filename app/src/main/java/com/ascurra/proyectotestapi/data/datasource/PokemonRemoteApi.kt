package com.ascurra.proyectotestapi.data.datasource

import com.ascurra.proyectotestapi.domain.model.PokemonDetail
import com.ascurra.proyectotestapi.domain.model.ServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonRemoteApi {

    @GET("pokemon")
    suspend fun list(@Query("offset") offset:Int,@Query("limit") limit:Int): Response<ServerResponse>

    @GET("pokemon/{pokemon}")
    suspend fun detail(@Query("pokemon") pokemonName:String): Response<PokemonDetail>
}
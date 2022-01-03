package com.ascurra.proyectotestapi.data.datasource

import com.ascurra.proyectotestapi.domain.model.PokemonDetail
import com.ascurra.proyectotestapi.domain.model.ServerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRemoteDatasource constructor(private val api:PokemonRemoteApi){
    suspend fun listPokemon(offset:Int,limit:Int):ServerResponse?{
        return withContext(Dispatchers.IO){
            val response = api.list(offset,limit)
            response.body()
        }
    }

    suspend fun detailPokemon(pokemonName:String):PokemonDetail?{
        return withContext(Dispatchers.IO){
            val response = api.detail(pokemonName)
            response.body()
        }
    }
}
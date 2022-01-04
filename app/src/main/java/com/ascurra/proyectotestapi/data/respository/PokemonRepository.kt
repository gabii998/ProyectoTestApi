package com.ascurra.proyectotestapi.data.respository

import com.ascurra.proyectotestapi.data.datasource.PokemonRemoteDatasource
import com.ascurra.proyectotestapi.domain.model.ServerResponse
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val remote:PokemonRemoteDatasource) {

    suspend fun list(offset:Int,limit:Int):ServerResponse? {
        val response = remote.listPokemon(offset,limit)
        return response
    }
}
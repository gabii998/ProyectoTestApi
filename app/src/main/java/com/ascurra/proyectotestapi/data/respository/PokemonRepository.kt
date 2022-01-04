package com.ascurra.proyectotestapi.data.respository

import com.ascurra.proyectotestapi.data.datasource.PokemonRemoteDatasource
import com.ascurra.proyectotestapi.domain.model.PokemonDetail
import com.ascurra.proyectotestapi.domain.model.ServerResponse
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val remote:PokemonRemoteDatasource) {

    suspend fun list(offset:Int,limit:Int):ServerResponse? {
        val response = remote.listPokemon(offset,limit)
        return response
    }

    suspend fun find(pokemonName:String):PokemonDetail? {
        val response = remote.detailPokemon(pokemonName)
        return response
    }
}
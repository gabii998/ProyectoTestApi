package com.ascurra.proyectotestapi.domain.usecase

import com.ascurra.proyectotestapi.data.respository.PokemonRepository
import com.ascurra.proyectotestapi.domain.model.ServerResponse
import javax.inject.Inject

class ListPokemon @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(offset:Int,limit:Int):ServerResponse? = repository.list(offset,limit)
}
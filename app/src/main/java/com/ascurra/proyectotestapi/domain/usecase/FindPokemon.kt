package com.ascurra.proyectotestapi.domain.usecase

import com.ascurra.proyectotestapi.data.respository.PokemonRepository
import com.ascurra.proyectotestapi.domain.model.PokemonDetail
import javax.inject.Inject

class FindPokemon @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(pokemonName:String): PokemonDetail? = repository.find(pokemonName)
}
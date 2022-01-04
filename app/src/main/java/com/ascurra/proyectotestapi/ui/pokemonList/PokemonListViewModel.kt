package com.ascurra.proyectotestapi.ui.pokemonList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ascurra.proyectotestapi.domain.model.Pokemon
import com.ascurra.proyectotestapi.domain.usecase.ListPokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val listPokemon: ListPokemon
): ViewModel() {
    val pokemons = MutableLiveData<List<Pokemon>>()
    private var offset = 0
    private var limit = 20

    fun listPokemons(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = listPokemon(offset,limit)
            if (result != null) {
                pokemons.postValue(result.results)
            }
        }
    }

    fun listMorePokemon(){
        CoroutineScope(Dispatchers.IO).launch {
            offset += 20
            val result = listPokemon(offset,limit)
            val previousValues:MutableList<Pokemon> = pokemons.value!!.toMutableList()
            if (result != null) {
                previousValues.addAll(result.results)
                pokemons.postValue(previousValues)
            }
        }
    }

}
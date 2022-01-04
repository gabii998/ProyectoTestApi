package com.ascurra.proyectotestapi.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ascurra.proyectotestapi.domain.model.Pokemon
import com.ascurra.proyectotestapi.domain.model.PokemonDetail
import com.ascurra.proyectotestapi.domain.usecase.FindPokemon
import com.ascurra.proyectotestapi.domain.usecase.ListPokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listPokemon: ListPokemon,
    private val findPokemon: FindPokemon
): ViewModel() {
    var pokemonDetail:MutableLiveData<PokemonDetail> = MutableLiveData()
    val pokemons = MutableLiveData<List<Pokemon>>()
    var waiting = false
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

    fun findPoke(name:String){
        CoroutineScope(Dispatchers.IO).launch {
            val result = findPokemon(name)
            pokemonDetail.postValue(result!!)
        }
    }

}
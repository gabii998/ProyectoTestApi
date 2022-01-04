package com.ascurra.proyectotestapi.ui.pokemonList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.ascurra.proyectotestapi.R
import com.ascurra.proyectotestapi.databinding.PokemonListFragmentBinding
import com.ascurra.proyectotestapi.domain.model.Pokemon
import com.ascurra.proyectotestapi.ui.adapter.PokemonAdapter
import com.ascurra.proyectotestapi.ui.main.MainViewModel
import com.ascurra.proyectotestapi.ui.pokemonDetail.PokemonDetailFragment

class PokemonListFragment : Fragment() {
    private lateinit var binding:PokemonListFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater,container,false)
        val pokemonList = mutableListOf<Pokemon>()
        val adapter = PokemonAdapter(pokemonList) {
            val pokemonName = it.tag as String
            viewModel.findPoke(pokemonName)
            viewModel.waiting = true
        }
        binding.rvPokemon.adapter = adapter
        //Escucha cambios en la lista de pokemons del viewModel
        viewModel.pokemons.observe(this,{
            if(binding.progressBar.visibility == View.VISIBLE){
                binding.progressBar.visibility = View.GONE
            }
            adapter.updateItems(it)
        })
        viewModel.pokemonDetail.observe(this,{
            if (viewModel.waiting){
                parentFragmentManager.beginTransaction().replace(R.id.contenedor,PokemonDetailFragment()).addToBackStack(null).commit()
                viewModel.waiting = false
            }
        })
        //Este listener es para cargar mas pokemones cuando se llega al final de lista, y mientras eso pasa muestra un indicador de carga
        binding.rvPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)){
                    viewModel.listMorePokemon()
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
        viewModel.listPokemons()

        return binding.root
    }
}
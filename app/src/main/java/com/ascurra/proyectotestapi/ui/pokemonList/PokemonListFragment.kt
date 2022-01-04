package com.ascurra.proyectotestapi.ui.pokemonList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ascurra.proyectotestapi.R
import com.ascurra.proyectotestapi.databinding.PokemonListFragmentBinding

class PokemonListFragment : Fragment() {
    private lateinit var binding:PokemonListFragmentBinding
    private val viewModel: PokemonListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater,container,false)

        viewModel.pokemons.observe(this,{

        })

        return binding.root
    }
}
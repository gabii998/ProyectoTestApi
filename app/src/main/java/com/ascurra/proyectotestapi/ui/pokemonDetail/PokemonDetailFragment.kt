package com.ascurra.proyectotestapi.ui.pokemonDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ascurra.proyectotestapi.R

class PokemonDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonDetailFragment()
    }

    private lateinit var viewModel: PokemonDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package com.ascurra.proyectotestapi.ui.pokemonDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ascurra.proyectotestapi.databinding.PokemonDetailFragmentBinding
import com.ascurra.proyectotestapi.ui.main.MainViewModel

class PokemonDetailFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: PokemonDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonDetailFragmentBinding.inflate(inflater,container,false)
        viewModel.pokemonDetail.observe(this,{
            var abilities:String = ""
            var stats:String = ""
            var forms:String = ""
            var types:String = ""
            it.abilities.forEachIndexed { index, ability ->
                abilities+=ability.ability.name
                if (index != it.abilities.size-1){
                    abilities+="\n"
                }
            }
            it.stats.forEachIndexed { index, stat ->
                stats+=stat.stat.name+":"+stat.baseStat
                if (index != it.stats.size-1){
                    stats+="\n"
                }
            }
            it.forms.forEachIndexed{index, pokemon ->
                forms+=pokemon.name
                if (index != it.forms.size-1){
                    forms+="\n"
                }
            }
            it.types.forEachIndexed{index, type ->
                types+=type.type.name
                if (index != it.types.size-1){
                    types+="\n"
                }
            }
            binding.pokemonName.text = it.name
            binding.width.text = it.weight.toString()
            binding.height.text = it.height.toString()
            binding.abilities.text = abilities
            binding.stats.text = stats
            binding.forms.text = forms
            binding.types.text = types
        })

        return binding.root
    }


}
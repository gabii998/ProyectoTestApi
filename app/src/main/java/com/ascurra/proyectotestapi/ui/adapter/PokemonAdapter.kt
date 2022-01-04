package com.ascurra.proyectotestapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ascurra.proyectotestapi.databinding.RvItemPokemonBinding
import com.ascurra.proyectotestapi.domain.model.Pokemon
import com.bumptech.glide.Glide

class PokemonAdapter(val items:MutableList<Pokemon>,val clickListener: View.OnClickListener): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    fun updateItems(newItems: List<Pokemon>){
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(RvItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false),clickListener)

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.onBind(items.get(position))

    override fun getItemCount(): Int = items.size

    class PokemonViewHolder(val binding: RvItemPokemonBinding,val clickListener: View.OnClickListener) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(pokemon:Pokemon){
            binding.pokemonName.text = pokemon.name[0].uppercaseChar() +pokemon.name.substring(1)
            binding.root.tag = pokemon.name
            binding.root.setOnClickListener(clickListener)
        }
    }
}
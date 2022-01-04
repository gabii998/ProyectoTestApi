package com.ascurra.proyectotestapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ascurra.proyectotestapi.databinding.RvItemPokemonBinding
import com.ascurra.proyectotestapi.domain.model.Pokemon

class PokemonAdapter(val items:MutableList<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(RvItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.onBind(items.get(position))

    override fun getItemCount(): Int = items.size

    class PokemonViewHolder(itemView: RvItemPokemonBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun onBind(pokemon:Pokemon){

        }
    }
}
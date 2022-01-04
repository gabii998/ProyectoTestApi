package com.ascurra.proyectotestapi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ascurra.proyectotestapi.R
import com.ascurra.proyectotestapi.ui.pokemonList.PokemonListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.contenedor,PokemonListFragment()).commit()
    }
}
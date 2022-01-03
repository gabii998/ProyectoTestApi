package com.ascurra.proyectotestapi.domain.model

data class PokemonDetail(
    val baseExperience:Int,
    val forms:List<Pokemon>,
    val gameIndices:List<GameIndex>,
    val height:Int,
    val id:Int,
    val weight:Int
)

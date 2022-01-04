package com.ascurra.proyectotestapi.domain.model

data class PokemonDetail(
    val baseExperience:Int,
    val forms:List<Pokemon>,
    val gameIndices:List<GameIndex>,
    val height:Int,
    val id:Int,
    val name:String,
    val types:List<Type>,
    val weight:Int,
    val abilities:List<AbilityWrapper>,
    val stats:List<Stat>
)

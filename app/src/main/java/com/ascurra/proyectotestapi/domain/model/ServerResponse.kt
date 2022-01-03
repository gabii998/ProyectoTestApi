package com.ascurra.proyectotestapi.domain.model

data class ServerResponse(
    val count:Int,
    val next:String,
    val previous:String,
    val results:List<Pokemon>
)

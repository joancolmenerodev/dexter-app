package com.example.dexter.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetPokemonResponse(val results: List<GetPokemonApiModel>)

@Serializable
data class GetPokemonApiModel(val name: String, val url: String)

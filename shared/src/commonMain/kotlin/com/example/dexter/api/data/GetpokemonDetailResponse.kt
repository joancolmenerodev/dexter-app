package com.example.dexter.api.data

import kotlinx.serialization.Serializable


@Serializable
data class GetPokemonDetailResponse(val id: Int, val sprites: SpritesResponse)

@Serializable
data class SpritesResponse(val front_default: String)

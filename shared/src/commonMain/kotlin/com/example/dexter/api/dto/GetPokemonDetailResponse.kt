package com.example.dexter.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPokemonDetailResponse(val id: Int, val sprites: SpritesResponse)

@Serializable
data class SpritesResponse(

    @SerialName("front_default")
    val url: String
)

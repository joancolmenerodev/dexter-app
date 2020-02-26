package com.example.dexter.repository.remote

import com.example.dexter.api.ServiceApi
import com.example.dexter.errors.Failure
import com.example.dexter.errors.tryEither
import com.example.dexter.models.PokemonDetail
import com.example.dexter.repository.BaseRepository
import com.example.dexter.types.Either

class PokemonDetailRepository(private val service: ServiceApi) : BaseRepository() {

    suspend fun getDetailPokemon(pokemonName: String): Either<Failure, PokemonDetail> =
        tryEither {
            val detail = service.getPokemonDetail(pokemonName)
            PokemonDetail(
                id = detail.id,
                name = detail.name,
                spriteUrl = detail.sprites.url,
                height = detail.height.toString(),
                weight = detail.weight.toString()

            )
        }
}
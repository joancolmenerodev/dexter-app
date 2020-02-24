package com.example.dexter.repository.remote

import com.example.dexter.api.ClientApi
import com.example.dexter.errors.Failure
import com.example.dexter.errors.tryEither
import com.example.dexter.models.Pokemon
import com.example.dexter.repository.BaseRepository
import com.example.dexter.types.Either
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class PokemonRepository : BaseRepository() {

    suspend fun getPokemons(): Either<Failure, List<Pokemon>> =
        tryEither {
            ClientApi.getPokemons().results.pmap {
                Pokemon(
                    name = it.name,
                    spriteUrl = getPokemonDetailResponse(it.name).sprites.url,
                    cached = false
                )
            }
        }

    private suspend fun getPokemonDetailResponse(name: String) =
        ClientApi.getPokemonDetail(name)
}

suspend fun <A, B> Iterable<A>.pmap(f: suspend (A) -> B): List<B> = coroutineScope {
    map { async { f(it) } }.awaitAll()
}


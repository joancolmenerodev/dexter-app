package com.example.dexter.repository.remote

import com.example.dexter.api.ServiceApi
import com.example.dexter.errors.Failure
import com.example.dexter.errors.tryEither
import com.example.dexter.models.Pokemon
import com.example.dexter.repository.BaseRepository
import com.example.dexter.types.Either
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class PokemonRepository(private val service: ServiceApi) : BaseRepository() {

    suspend fun getPokemons(offset: Int, limit: Int): Either<Failure, List<Pokemon>> =
        tryEither {
            service.getPokemons(offset, limit).results.pmap {
                val detail = getPokemonDetailResponse(it.name)
                Pokemon(
                    id = detail.id,
                    name = it.name,
                    spriteUrl = detail.sprites.url,
                    cached = false
                )
            }
        }

    private suspend fun getPokemonDetailResponse(name: String) =
        service.getPokemonDetail(name)
}

suspend fun <A, B> Iterable<A>.pmap(f: suspend (A) -> B): List<B> = coroutineScope {
    map { async { f(it) } }.awaitAll()
}


package com.example.dexter.interactors

import com.example.dexter.errors.Failure
import com.example.dexter.errors.tryEither
import com.example.dexter.interactors.base.UseCase
import com.example.dexter.repository.data.Pokemon
import com.example.dexter.repository.remote.PokemonRepository
import com.example.dexter.types.Either
import kotlin.coroutines.CoroutineContext

class GetPokemonsUseCase(foreground: CoroutineContext) : UseCase<List<Pokemon>, Unit>(foreground) {

    override suspend fun run(parameter: Unit?): Either<Failure, List<Pokemon>> = tryEither {
        PokemonRepository().getPokemons()
    }
}
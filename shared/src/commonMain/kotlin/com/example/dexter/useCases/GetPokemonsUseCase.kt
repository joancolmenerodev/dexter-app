package com.example.dexter.interactors

import com.example.dexter.errors.Failure
import com.example.dexter.errors.PokemonListFailure
import com.example.dexter.interactors.base.UseCase
import com.example.dexter.models.Pokemon
import com.example.dexter.repository.remote.PokemonRepository
import com.example.dexter.types.Either
import com.example.dexter.types.flatMapL
import kotlin.coroutines.CoroutineContext

class GetPokemonsUseCase(
    private val pokemonRepository: PokemonRepository,
    foreground: CoroutineContext) : UseCase<List<Pokemon>, PokemonListFailure, Unit>(foreground) {

    override suspend fun run(parameter: Unit?): Either<PokemonListFailure, List<Pokemon>> =
        pokemonRepository.getPokemons()
            .flatMapL { failure: Failure ->
                when (failure) {
                    is Failure.ServiceUnavailable -> {
                        Either.Left(PokemonListFailure.FailureLoadingList)
                    }
                    else -> {
                        Either.Left(PokemonListFailure.Unexpected(failure))
                    }
                }
            }
}

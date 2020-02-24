package com.example.dexter.useCases

import com.example.dexter.errors.Failure
import com.example.dexter.errors.PokemonListFailure
import com.example.dexter.useCases.base.UseCase
import com.example.dexter.models.Pokemon
import com.example.dexter.repository.remote.PokemonRepository
import com.example.dexter.types.Either
import com.example.dexter.types.flatMapL
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class GetPokemonsUseCase(
    private val pokemonRepository: PokemonRepository,
    foreground: CoroutineContext = Dispatchers.Main
) : UseCase<List<Pokemon>, PokemonListFailure, Unit>(foreground) {

    override suspend fun run(parameter: Unit?): Either<PokemonListFailure, List<Pokemon>> =
        pokemonRepository.getPokemons(0, 50)
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

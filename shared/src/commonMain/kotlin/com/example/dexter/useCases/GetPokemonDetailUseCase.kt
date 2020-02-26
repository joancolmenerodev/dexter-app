package com.example.dexter.useCases

import com.example.dexter.errors.Failure
import com.example.dexter.errors.PokemonDetailFailure
import com.example.dexter.models.PokemonDetail
import com.example.dexter.repository.remote.PokemonDetailRepository
import com.example.dexter.types.Either
import com.example.dexter.types.flatMapL
import com.example.dexter.useCases.base.UseCase
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class GetPokemonDetailUseCase(
    private val pokemonDetailRepository: PokemonDetailRepository,
    foreground: CoroutineContext = Dispatchers.Main
) : UseCase<PokemonDetail, PokemonDetailFailure, String>(foreground) {

    override suspend fun run(parameter: String?): Either<PokemonDetailFailure, PokemonDetail> {
        parameter?.let {
            return pokemonDetailRepository.getDetailPokemon(it).flatMapL { failure: Failure ->
                when (failure) {
                    is Failure.ServiceUnavailable -> {
                        Either.Left(PokemonDetailFailure.FailureLoadingDetail)
                    }
                    else -> {
                        Either.Left(PokemonDetailFailure.Unexpected(failure))
                    }
                }
            }

        }
        return Either.Left(PokemonDetailFailure.WrongParameter)
    }

}
package com.example.dexter.errors

sealed class Failure(cause: Exception? = null): Exception(cause) {

    object WrongParameters: Failure()
    object NotFound: Failure()
    object ServiceUnavailable: Failure()
    class Internal(cause: Exception): Failure(cause)
}

sealed class PokemonListFailure(cause: Exception? = null): Failure(cause) {

    object FailureLoadingList: PokemonListFailure()
    class Unexpected(cause: Exception): PokemonListFailure(cause)
}

sealed class PokemonDetailFailure(cause: Exception? = null): Failure(cause) {

    object FailureLoadingDetail: PokemonDetailFailure()
    object WrongParameter : PokemonDetailFailure()
    class Unexpected(cause: Exception): PokemonDetailFailure(cause)
}

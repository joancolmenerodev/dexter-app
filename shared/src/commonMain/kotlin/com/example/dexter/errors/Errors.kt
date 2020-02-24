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

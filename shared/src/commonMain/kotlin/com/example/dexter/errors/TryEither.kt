package com.example.dexter.errors

import com.example.dexter.types.Either

/**
 * Function that receive a function a return an Either with [Failure] exception
 */
suspend fun <T> tryEither(request: suspend () -> T): Either<Failure, T> =
    try {
        Either.Right(request())
    } catch (ex: Failure) {
        Either.Left(ex)
    }

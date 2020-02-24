package com.example.dexter.types

/**
 * Either monad
 * Represents values with two disjunctive possibilities
 *
 * Reference: https://leanpub.com/theneophytesguidetoscala
 */
sealed class Either<out L, out R> {

    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get(): Boolean = this is Right<R>
    val isLeft get(): Boolean = this is Left<L>

    fun <L> left(a: L) = Left(a)

    fun <R> right(b: R) = Right(b)

    fun <T> fold(ifLeft: (L) -> T, ifRight: (R) -> T): T =
        when (this) {
            is Left -> ifLeft(a)
            is Right -> ifRight(b)
        }

    fun toOptional(): Optional<R> =
        when (this) {
            is Left -> Optional.None
            is Right -> Optional.Some(b)
        }

}

fun <L, R, T> Either<L, R>.flatMapR(transform: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> left(a)
        is Either.Right -> transform(b)
    }

fun <L, R, T> Either<L, R>.flatMapL(transform: (L) -> Either<T, R>): Either<T, R> =
    when (this) {
        is Either.Left -> transform(a)
        is Either.Right -> right(b)
    }

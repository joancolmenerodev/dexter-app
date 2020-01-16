package com.example.dexter.types

/**
 * Optional monad
 * Represents values that could be present or not
 *
 * Reference: https://leanpub.com/theneophytesguidetoscala
 */
sealed class Optional<out T> {

    abstract fun toNullable(): T?

    data class Some<out T>(val orNull: T) : Optional<T>() {

        override fun toString() = "Some($orNull)"
        override fun toNullable(): T? = component1()
    }

    object None : Optional<Nothing>() {

        override fun toString() = "None"
        override fun toNullable(): Nothing? = null
    }

    fun <T : Any> T?.toOptional(): Optional<T> = if (this == null) None else Some(this)

}

package com.example.dexter.errors

sealed class Failure(message: String? = null): Exception(message) {

    object WrongParameters: Failure("The input parameters were wrong")
    object PaymentRequired: Failure("Can't complete this action without payment")
    object InvalidToken: Failure("The provided token was invalid")
    object Forbidden: Failure("Forbidden access to the resource")
    object NotFound: Failure("The requested resource was not found")
    object ServiceUnavailable: Failure("Service failure")

    class Internal(message: String?): Failure(message)

    override fun toString(): String {
        return super.message ?: super.toString()
    }
}

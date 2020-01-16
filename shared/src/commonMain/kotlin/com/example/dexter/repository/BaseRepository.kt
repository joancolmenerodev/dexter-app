package com.example.dexter.repository

import com.example.dexter.errors.Failure
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.features.BadResponseStatusException

abstract class BaseRepository {

    suspend fun <T> tryNetworkCall(call: suspend () -> T): T =
        try {
            call()
        } catch (pipelineError: ReceivePipelineException) {
            throw checkStatus(pipelineError.request.response.status.value, pipelineError.message)
        } catch (statusError: BadResponseStatusException) {
            throw checkStatus(statusError.statusCode.value, statusError.message)
        } catch (error: Throwable) {
            throw Failure.Internal(error.message)
        }

    private fun checkStatus(status: Int?, message: String? = null): Throwable {
        return when (status) {
            400 -> Failure.WrongParameters
            402 -> Failure.PaymentRequired
            401 -> Failure.InvalidToken
            403 -> Failure.Forbidden
            404 -> Failure.NotFound
            500, 503 -> Failure.ServiceUnavailable
            else -> Failure.Internal(message)
        }
    }

}

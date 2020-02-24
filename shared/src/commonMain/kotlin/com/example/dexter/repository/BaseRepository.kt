package com.example.dexter.repository

import com.example.dexter.errors.Failure
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.features.BadResponseStatusException

abstract class BaseRepository {

    suspend fun <T> tryNetworkCall(call: suspend () -> T): T =
        try {
            call()
        } catch (pipelineError: ReceivePipelineException) {
            throw checkStatus(pipelineError.request.response.status.value, pipelineError)
        } catch (statusError: BadResponseStatusException) {
            throw checkStatus(statusError.statusCode.value, statusError)
        } catch (error: Exception) {
            throw Failure.Internal(error)
        }

    private fun checkStatus(status: Int?, cause: Exception? = null): Exception =
        when (status) {
            400 -> Failure.WrongParameters
            404 -> Failure.NotFound
            500, 503 -> Failure.ServiceUnavailable
            else -> Failure.Internal(cause ?: IllegalStateException("Status: $status"))
        }
}

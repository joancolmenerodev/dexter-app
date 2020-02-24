package com.example.dexter.api

import com.example.dexter.api.dto.GetPokemonApiModel
import com.example.dexter.api.dto.GetPokemonDetailResponse
import com.example.dexter.api.dto.GetPokemonResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

@Suppress("EXPERIMENTAL_API_USAGE")
class ServiceApi(private val baseUrl: String) {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict).apply {
                registerList(GetPokemonApiModel.serializer().list)
            }
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
    }

    suspend fun getPokemons(offset: Int, limit: Int): GetPokemonResponse = client.get {
        apiUrl("api/v2/pokemon?offset=$offset&limit=$limit")
    }

    suspend fun getPokemonDetail(name: String): GetPokemonDetailResponse = client.get {
        apiUrl("api/v2/pokemon/$name")
    }

    private fun HttpRequestBuilder.json() {
        contentType(ContentType.Application.Json)
    }

    private fun HttpRequestBuilder.apiUrl(path: String) {
        header(HttpHeaders.CacheControl, "no-cache")
        url {
            takeFrom(baseUrl)
            encodedPath = path
        }
    }

}

package com.example.dexter.api

import com.example.dexter.api.data.GetPokemonApiModel
import com.example.dexter.api.data.GetPokemonDetailResponse
import com.example.dexter.api.data.GetPokemonResponse
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import kotlin.native.concurrent.*

@ThreadLocal
object ClientApi {
    val endpoint = "https://pokeapi.co"

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(JSON.nonstrict).apply {
                registerList(GetPokemonApiModel.serializer().list)
            }
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
    }


    suspend fun getPokemons(): GetPokemonResponse = client.get {
        apiUrl("api/v2/pokemon")
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
            takeFrom(endpoint)
            encodedPath = path
        }
    }

}
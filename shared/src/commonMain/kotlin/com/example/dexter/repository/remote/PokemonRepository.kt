package com.example.dexter.repository.remote

import com.example.dexter.api.ClientApi
import com.example.dexter.repository.BaseRepository
import com.example.dexter.repository.data.Pokemon

class PokemonRepository : BaseRepository() {

    suspend fun getPokemons(): List<Pokemon> {
        return ClientApi.getPokemons().results.map {
            // TODO: This is super slow :( Any idea @Max? -> Parallelize
            val spriteUrl = ClientApi.getPokemonDetail(it.name).sprites.front_default
            Pokemon(it.name, spriteUrl)
        }
    }
}
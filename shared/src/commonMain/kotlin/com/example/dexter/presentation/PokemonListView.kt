package com.example.dexter.presentation

import com.example.dexter.models.Pokemon

interface PokemonListView {

    fun showLoading()
    fun hideLoading()
    fun showServiceError()
    fun showPokemons(list: List<Pokemon>)
}

package com.example.dexter.presentation.list

import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.base.BaseView

interface PokemonListView : BaseView {

    fun showServiceError()
    fun showPokemons(list: List<Pokemon>)
    fun navigateToDetail(pokemonName: String)
}

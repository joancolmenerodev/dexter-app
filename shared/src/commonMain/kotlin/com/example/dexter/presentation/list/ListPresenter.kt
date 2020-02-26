package com.example.dexter.presentation.list

import com.example.dexter.presentation.base.BasePresenter

interface ListPresenter : BasePresenter<PokemonListView> {

    fun onPokemonClicked(pokemonName: String)
}

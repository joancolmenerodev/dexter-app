package com.example.dexter.presentation.detail

import com.example.dexter.presentation.base.BaseView

interface PokemonDetailView : BaseView {

    fun showPokemonName(name: String)
    fun showPokemonImage(url: String)
    fun showHeight(height: String)
    fun showWeight(weight: String)
    fun showError()
}
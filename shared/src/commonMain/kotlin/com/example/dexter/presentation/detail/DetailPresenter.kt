package com.example.dexter.presentation.detail

import com.example.dexter.presentation.base.BasePresenter

interface DetailPresenter : BasePresenter<PokemonDetailView> {
    fun onViewReady(view: PokemonDetailView, param: String?)
}
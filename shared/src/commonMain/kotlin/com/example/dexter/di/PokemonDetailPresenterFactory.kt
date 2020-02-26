package com.example.dexter.di

import com.example.dexter.presentation.detail.PokemonDetailPresenter
import com.example.dexter.useCases.GetPokemonDetailUseCase
import com.example.dexter.utils.Logger

class PokemonDetailPresenterFactory(
    private val getPokemonsDetailUseCase: GetPokemonDetailUseCase,
    private val logger: Logger
) : Factory<PokemonDetailPresenter> {

    override fun create(): PokemonDetailPresenter =
        PokemonDetailPresenter(
            getPokemonsDetailUseCase,
            logger
        )
}
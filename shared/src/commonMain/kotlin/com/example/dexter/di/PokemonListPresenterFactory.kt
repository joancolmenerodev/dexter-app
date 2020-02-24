package com.example.dexter.di

import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.useCases.GetPokemonsUseCase
import com.example.dexter.utils.Logger

class PokemonListPresenterFactory(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val logger: Logger
) : Factory<PokemonListPresenter> {

    override fun create(): PokemonListPresenter =
        PokemonListPresenter(getPokemonsUseCase, logger)
}

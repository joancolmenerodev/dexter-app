package com.example.dexter.di

import com.example.dexter.api.ServiceApi
import com.example.dexter.repository.remote.PokemonRepository
import com.example.dexter.useCases.GetPokemonsUseCase
import com.example.dexter.utils.Logger
import kotlin.coroutines.CoroutineContext

class AppContainer(foreground: CoroutineContext) {

    private val service = ServiceApi("https://pokeapi.co")

    private val pokemonRepository = PokemonRepository(service)

    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonRepository, foreground)

    private val logger = Logger()

    val pokemonListPresenterFactory = PokemonListPresenterFactory(getPokemonsUseCase, logger)
}


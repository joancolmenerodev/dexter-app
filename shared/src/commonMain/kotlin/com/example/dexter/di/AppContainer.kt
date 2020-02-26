package com.example.dexter.di

import com.example.dexter.api.ServiceApi
import com.example.dexter.repository.remote.PokemonDetailRepository
import com.example.dexter.repository.remote.PokemonListRepository
import com.example.dexter.useCases.GetPokemonDetailUseCase
import com.example.dexter.useCases.GetPokemonsUseCase
import com.example.dexter.utils.Logger
import kotlin.coroutines.CoroutineContext

class AppContainer(foreground: CoroutineContext) {

    private val service = ServiceApi("https://pokeapi.co")

    private val pokemonListRepository = PokemonListRepository(service)

    private val pokemonDetailRepository = PokemonDetailRepository(service)

    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonListRepository, foreground)

    private val getPokemonsDetailUseCase = GetPokemonDetailUseCase(pokemonDetailRepository, foreground)

    private val logger = Logger()

    val pokemonListPresenterFactory = PokemonListPresenterFactory(getPokemonsUseCase, logger)

    val pokemonDetailPresenterFactory = PokemonDetailPresenterFactory(getPokemonsDetailUseCase, logger)


}


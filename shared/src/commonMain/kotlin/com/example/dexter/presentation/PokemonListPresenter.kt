package com.example.dexter.presentation

import com.example.dexter.interactors.GetPokemonsUseCase
import com.example.dexter.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PokemonListPresenter : BasePresenter<PokemonListView> {

    private var getPokemonsUseCase: GetPokemonsUseCase? = null

    override fun onViewReady(view: PokemonListView) {
        println("test")

        getPokemonsUseCase = GetPokemonsUseCase(Dispatchers.Main)
        getPokemonsUseCase!!.cancel()
        // TODO execute is not run in the unit tests :( ExampleUnitTest
        getPokemonsUseCase!!.execute {
            println("hello")
            val result = it.toOptional().toNullable()
            view.showPokemons()
            println(result)
        }
    }

    override fun onViewDestroyed() {
        getPokemonsUseCase?.cancel()
    }
}
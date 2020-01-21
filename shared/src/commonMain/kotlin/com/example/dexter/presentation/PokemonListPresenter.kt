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

        getPokemonsUseCase = GetPokemonsUseCase(Dispatchers.Main)
        getPokemonsUseCase!!.execute {
            val result = it.toOptional().toNullable()
            view.showPokemons()
        }
    }

    override fun onViewDestroyed() {
        getPokemonsUseCase?.cancel()
    }
}
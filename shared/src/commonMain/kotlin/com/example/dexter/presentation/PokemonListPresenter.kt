package com.example.dexter.presentation

import com.example.dexter.errors.PokemonListFailure
import com.example.dexter.interactors.GetPokemonsUseCase
import com.example.dexter.presentation.base.BasePresenter
import com.example.dexter.utils.Log

class PokemonListPresenter(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val logger: Log
) : BasePresenter<PokemonListView> {

    override fun onViewReady(view: PokemonListView) {
        view.showLoading()
        getPokemonsUseCase.execute { either ->
            view.hideLoading()
            either.fold(
                { failure ->
                    when (failure) {
                        is PokemonListFailure.FailureLoadingList -> view.showServiceError()
                        is PokemonListFailure.Unexpected -> {
                            logger.error("Unexpected eror: $failure ${failure.message}")
                            throw failure
                        }
                    }
                },
                { list ->
                    view.showPokemons(list)
                }
            )
        }
    }

    override fun onViewDestroyed() {
        getPokemonsUseCase.cancel()
    }
}

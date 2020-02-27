package com.example.dexter.presentation.list

import com.example.dexter.errors.PokemonListFailure
import com.example.dexter.presentation.base.AbstractPresenter
import com.example.dexter.useCases.GetPokemonsUseCase
import com.example.dexter.utils.Logger

class PokemonListPresenter(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val logger: Logger
) : AbstractPresenter<PokemonListView>(), ListPresenter {

    override fun onViewReady(view: PokemonListView) {
        super.onViewReady(view)
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
        super.onViewDestroyed()
        getPokemonsUseCase.cancel()
    }

    override fun onPokemonClicked(pokemonName: String) {
        view?.navigateToDetail(pokemonName)

    }
}

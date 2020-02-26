package com.example.dexter.presentation.detail

import com.example.dexter.errors.PokemonDetailFailure
import com.example.dexter.useCases.GetPokemonDetailUseCase
import com.example.dexter.utils.Logger

class PokemonDetailPresenter(
    private val getPokemonsDetailUseCase: GetPokemonDetailUseCase,
    private val logger: Logger
) : DetailPresenter {

    override fun onViewReady(view: PokemonDetailView, param: String?) {
        view.showLoading()
        getPokemonsDetailUseCase.execute(param) { either ->
            view.hideLoading()
            either.fold(
                { failure ->
                    when (failure) {
                        is PokemonDetailFailure.FailureLoadingDetail -> view.showError()
                        is PokemonDetailFailure.WrongParameter -> view.showError()
                        is PokemonDetailFailure.Unexpected -> {
                            logger.error("Unexpected error: $failure ${failure.message}")
                            throw failure
                        }
                    }
                },
                { detail ->
                    view.showHeight(detail.height)
                    view.showWeight(detail.weight)
                    view.showPokemonName(detail.name)
                    view.showPokemonImage(detail.spriteUrl)
                }
            )
        }
    }

    override fun onViewDestroyed() {
        getPokemonsDetailUseCase.cancel()
    }
}
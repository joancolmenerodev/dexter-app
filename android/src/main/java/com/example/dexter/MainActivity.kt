package com.example.dexter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView

class MainActivity : AppCompatActivity(), PokemonListView {

    private lateinit var presenter: PokemonListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()

        presenter.onViewReady(this)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showServiceError() {

    }

    override fun showPokemons(list: List<Pokemon>) {

    }

    private fun inject() {
        val appContainer = (application as DexterApplication).appContainer
        presenter = appContainer.pokemonListPresenterFactory.create()
    }
}

package com.example.dexter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PokemonListView {

    private lateinit var presenter: PokemonListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()

        presenter.onViewReady(this)
    }

    override fun showLoading() {
        println("SHOW LOADING")
    }

    override fun hideLoading() {
        println("HIDE LOADING")
    }

    override fun showServiceError() {
        Snackbar.make(container, getString(R.string.error_service), Snackbar.LENGTH_LONG).show()
    }

    override fun showPokemons(list: List<Pokemon>) {
        println(list)
    }

    private fun inject() {
        val appContainer = (application as DexterApplication).appContainer
        presenter = appContainer.pokemonListPresenterFactory.create()
    }
}

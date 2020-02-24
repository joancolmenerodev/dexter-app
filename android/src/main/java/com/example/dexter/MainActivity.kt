package com.example.dexter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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

        setupList()
        presenter.onViewReady(this)
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun showServiceError() {
        Snackbar.make(container, getString(R.string.error_service), Snackbar.LENGTH_LONG).show()
    }

    override fun showPokemons(list: List<Pokemon>) {
        (pokemonList.adapter as PokemonListAdapter).addItems(list)
    }

    private fun setupList() {
        pokemonList.setHasFixedSize(true)
        pokemonList.layoutManager = GridLayoutManager(this, 3)
        pokemonList.adapter = PokemonListAdapter()
    }

    private fun inject() {
        val appContainer = (application as DexterApplication).appContainer
        presenter = appContainer.pokemonListPresenterFactory.create()
    }
}

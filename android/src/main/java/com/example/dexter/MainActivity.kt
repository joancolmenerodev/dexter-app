package com.example.dexter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.list.PokemonListPresenter
import com.example.dexter.presentation.list.PokemonListView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    PokemonListView {

    private lateinit var presenter: PokemonListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()

        setupList()
        presenter.onViewReady(this)
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
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

    override fun navigateToDetail(pokemonName: String) {
        startActivity(PokemonDetail.getPokemonDetailIntent(this, pokemonName))
    }

    private fun setupList() {
        pokemonList.setHasFixedSize(true)
        pokemonList.layoutManager = GridLayoutManager(this, 3)
        pokemonList.adapter = PokemonListAdapter { pokemonName ->
            presenter.onPokemonClicked(pokemonName)
        }
    }

    private fun inject() {
        val appContainer = (application as DexterApplication).appContainer
        presenter = appContainer.pokemonListPresenterFactory.create()
    }
}

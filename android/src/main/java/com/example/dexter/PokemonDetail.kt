package com.example.dexter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dexter.presentation.detail.PokemonDetailPresenter
import com.example.dexter.presentation.detail.PokemonDetailView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class PokemonDetail : AppCompatActivity(), PokemonDetailView {

    private lateinit var presenter: PokemonDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        inject()

        getPokemonName()?.let { presenter.onViewReady(this, it) }
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }

    override fun showPokemonName(name: String) {
        detail_name.text = name
    }

    override fun showHeight(height: String) {
        detail_height.text = this.getString(R.string.detail_height, height)
    }

    override fun showWeight(weight: String) {
        detail_weight.text = this.getString(R.string.detail_weight, weight)
    }

    override fun showError() {
        Snackbar.make(detail_container, getString(R.string.error_service), Snackbar.LENGTH_LONG)
            .show()
    }

    override fun showLoading() {
        loading_detail.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading_detail.visibility = View.GONE
    }

    override fun showPokemonImage(url: String) {
        detail_image.loadUrl(url)
    }

    private fun inject() {
        val appContainer = (application as DexterApplication).appContainer
        presenter = appContainer.pokemonDetailPresenterFactory.create()
    }

    private fun getPokemonName() : String? = intent?.extras?.getString(POKEMON_NAME)

    companion object {

        private var POKEMON_NAME: String = "POKEMON_NAME"

        @JvmStatic
        fun getPokemonDetailIntent(context: Context, pokemonName: String): Intent =
            Intent(context, PokemonDetail::class.java)
                .apply {
                    putExtra(POKEMON_NAME, pokemonName)
                }
    }
}

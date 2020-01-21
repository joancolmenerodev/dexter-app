package com.example.dexter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView

class MainActivity : AppCompatActivity(), PokemonListView {

    val presenter: PokemonListPresenter = PokemonListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewReady(this)
    }

    override fun showPokemons() {
        println("showPokemons called")
    }
}

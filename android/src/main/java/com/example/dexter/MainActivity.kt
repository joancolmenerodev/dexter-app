package com.example.dexter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView

class MainActivity : AppCompatActivity(), PokemonListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showServiceError() {

    }

    override fun showPokemons(list: List<Pokemon>) {

    }
}

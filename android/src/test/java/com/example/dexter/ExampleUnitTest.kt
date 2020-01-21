package com.example.dexter

import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView
import com.example.dexter.repository.data.Pokemon
import com.example.dexter.repository.remote.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    private lateinit var mockView: PokemonListView


    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testRepository() {
        runBlocking {
            val pokemons = PokemonRepository().getPokemons().toOptional().toNullable()
            pokemons?.forEach {
                println(it)
            }
        }
    }

    @Test
    fun testPresenter() {
        runBlocking {
            launch(Dispatchers.Main) {
                val presenter = PokemonListPresenter()
                presenter.onViewReady(mockView)
            }
            Mockito.verify(mockView).showPokemons()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}

package com.example.dexter

import com.example.dexter.models.Pokemon
import com.example.dexter.presentation.PokemonListPresenter
import com.example.dexter.presentation.PokemonListView
import com.example.dexter.repository.remote.PokemonRepository
import com.example.dexter.types.Either
import com.example.dexter.useCases.GetPokemonsUseCase
import com.example.dexter.utils.Logger
import com.nhaarman.mockitokotlin2.stub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.mock


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
class ExampleUnitTest {

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
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
            val mockView = mock(PokemonListView::class.java)
            val repository = mock(PokemonRepository::class.java)
            val list = listOf<Pokemon>()
            repository.stub {
                onBlocking { getPokemons() }.thenReturn(Either.Right(list))
            }
            val presenter = PokemonListPresenter(GetPokemonsUseCase(repository), Logger())
            presenter.onViewReady(mockView)
            Mockito.verify(mockView).showLoading()


            Mockito.verify(mockView).hideLoading()
            Mockito.verify(mockView).showPokemons(list)
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}

package com.example.dexter

import android.app.Application
import com.example.dexter.di.AppContainer
import kotlinx.coroutines.Dispatchers

class DexterApplication: Application() {

    val appContainer = AppContainer(Dispatchers.Main)
}

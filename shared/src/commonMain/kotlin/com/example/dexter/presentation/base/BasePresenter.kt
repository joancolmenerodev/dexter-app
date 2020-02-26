package com.example.dexter.presentation.base

interface BasePresenter<T> {

    fun onViewReady(view: T, param: String? = null)
    fun onViewDestroyed()
}

package com.example.dexter.presentation.base

interface BasePresenter<T> {
    fun onViewReady(view: T)
    fun onViewDestroyed()
}
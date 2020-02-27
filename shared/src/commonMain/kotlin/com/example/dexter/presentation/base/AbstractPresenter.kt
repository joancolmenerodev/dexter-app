package com.example.dexter.presentation.base

abstract class AbstractPresenter<T : BaseView> : BasePresenter<T> {
    protected var view: T? = null

    override fun onViewReady(view: T) {
        this.view = view
    }

    override fun onViewDestroyed() {
        view = null
    }
}
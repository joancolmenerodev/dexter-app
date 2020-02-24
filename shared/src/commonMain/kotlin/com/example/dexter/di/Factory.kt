package com.example.dexter.di

interface Factory<T> {

    fun create(): T
}

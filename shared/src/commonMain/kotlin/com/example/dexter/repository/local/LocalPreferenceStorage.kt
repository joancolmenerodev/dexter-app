package com.example.dexter.repository.local

expect class LocalPreferenceStorage {

    fun save(key: String, value: String)
    fun retrieve(key: String) : String?
    fun remove(key: String)

}

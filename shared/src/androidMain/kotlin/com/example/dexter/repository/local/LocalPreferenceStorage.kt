package com.example.dexter.repository.local

import android.content.Context
import android.content.SharedPreferences

actual class LocalPreferenceStorage(context: Context) {

    companion object {
        const val PREFERENCES = "com.example.dexter"
    }

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    actual fun save(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    actual fun retrieve(key: String): String? {
        return preferences.getString(key, null)
    }

    actual fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }

}

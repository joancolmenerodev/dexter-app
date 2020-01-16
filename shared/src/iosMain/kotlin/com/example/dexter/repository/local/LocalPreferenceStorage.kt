package com.example.dexter.repository.local

import platform.Foundation.NSUserDefaults

actual class LocalPreferenceStorage {

    private val delegate: NSUserDefaults = NSUserDefaults.standardUserDefaults()

    actual fun save(key: String, value: String) {
        delegate.setObject(value, key)
    }

    actual fun retrieve(key: String): String? = delegate.stringForKey(key)

    actual fun remove(key: String) {
        delegate.removeObjectForKey(key)
    }

}

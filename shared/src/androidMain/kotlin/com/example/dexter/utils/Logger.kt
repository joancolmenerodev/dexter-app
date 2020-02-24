package com.example.dexter.utils

typealias AndroigLog = android.util.Log

actual class Logger {

    actual fun debug(message: String, formatJson: Boolean) {
        AndroigLog.d(TAG, message)
    }

    actual fun error(message: String) {
        AndroigLog.e(TAG, message)
    }

    actual fun warning(message: String) {
        AndroigLog.w(TAG, message)
    }

    actual fun verbose(message: String) {
        AndroigLog.v(TAG, message)
    }

    actual fun information(message: String) {
        AndroigLog.i(TAG, message)
    }

    companion object {
        const val TAG = "DEXTER"
    }
}

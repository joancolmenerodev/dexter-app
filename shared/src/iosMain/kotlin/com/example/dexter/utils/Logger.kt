package com.example.dexter.utils

import platform.Foundation.NSLog

actual class Logger {

    actual fun debug(message: String, formatJson: Boolean) {
        NSLog(message)
    }

    actual fun error(message: String) {
        NSLog(message)
    }

    actual fun warning(message: String) {
        NSLog(message)
    }

    actual fun verbose(message: String) {
        NSLog(message)
    }

    actual fun information(message: String) {
        NSLog(message)
    }

}

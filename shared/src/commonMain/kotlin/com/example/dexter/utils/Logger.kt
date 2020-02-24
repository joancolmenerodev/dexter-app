package com.example.dexter.utils


expect class Logger {

    fun debug(message: String, formatJson: Boolean = false)
    fun error(message: String)
    fun warning(message: String)
    fun verbose(message: String)
    fun information(message: String)

}

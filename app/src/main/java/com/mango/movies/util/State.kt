package com.mango.movies.util

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error(val message: String) : State<Nothing>()
    object Loading : State<Nothing>()

    fun toData() = if (this is Success) data else null
}

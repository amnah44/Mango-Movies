package com.mango.movies.util

import androidx.lifecycle.Observer

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfHandled(): T? {
        return if (hasBeenHandled)
            null
        else {
            hasBeenHandled = true
            content
        }
    }
}

class EventObserve<T>(
    private val onEventUnhandledContent: (T) -> Unit
) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfHandled()?.let {
            onEventUnhandledContent(it)
        }
    }

}
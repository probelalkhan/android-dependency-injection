package net.simplifiedcoding.ui.auth

interface Factory<T> {
    fun create() : T
}
package com.rebwon.kotlinstudy.monad

sealed class Result<T> {
    data class Success<T>(val value: T) : Result<T>()
    class Fail<T>: Result<T>()

    fun value(onSuccess: (T) -> Unit, onFail: (Fail<T>) -> Unit) {
        return when(this) {
            is Result.Success -> onSuccess(value)
            is Result.Fail -> onFail(this)
        }
    }
}

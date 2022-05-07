package com.rebwon.kotlinstudy.monad

sealed class Optional<T> {
    class None<T>: Optional<T>()
    data class Some<T>(val value: T): Optional<T>()
}

infix fun <T, R> Optional<T>.map(functor: (value: T) -> R): Optional<R> {
    return this.flatMap { value ->
        Optional.Some(functor(value))
    }
}

infix fun <T, R> Optional<T>.flatMap(functor: (value: T) -> Optional<R>): Optional<R> {
    return when (this) {
        is Optional.Some -> {
            functor(this.value)
        }
        is Optional.None -> {
            Optional.None()
        }
    }
}

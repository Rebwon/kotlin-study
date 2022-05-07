package com.rebwon.kotlinstudy.monad

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()
}

infix fun <L, R, P> Either<L, R>.map(f: (R) -> P): Either<L, P> {
    return this.flatMap { value ->
        Either.Right(f(value))
    }
}

infix fun <L, R, Q> Either<L, R>.flatMap(f: (R) -> Either<L, Q>): Either<L, Q> {
    return when (this) {
        is Either.Left -> Either.Left(this.value)
        is Either.Right -> f(this.value)
    }
}

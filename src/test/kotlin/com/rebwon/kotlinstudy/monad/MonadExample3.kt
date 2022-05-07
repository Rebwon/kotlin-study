package com.rebwon.kotlinstudy.monad

infix fun <T, R> Result<T>.map(functor: (value: T) -> R): Result<R> {
    return this.flatMap {
        value ->
        Result.Success(functor(value))
    }
}

infix fun <T, R> Result<T>.flatMap(functor: (value: T) -> Result<R>): Result<R> {
    return when (this) {
        is Result.Success -> functor(this.value)
        is Result.Fail -> Result.Fail()
    }
}

fun a1(value: Int): Result<Int> {
    if (value > 0) {
        return Result.Success(value * 10)
    } else {
        return Result.Fail()
    }
}

fun d1(value: Int): Int {
    return value * 10
}

fun value(value: Result<Int>): Int {
    return when (value) {
        is Result.Success -> {
            value.value
        }
        is Result.Fail -> {
            -1
        }
    }
}

fun main() {
    val flow1 = a(10) map ::d1 flatMap ::a1
    println(value(flow1))

    val flow2 = a(10) map ::d1 flatMap ::a1 map { "Success : $it" }
    flow2.value(
        onSuccess = { println(it) },
        onFail = { println("Fail") }
    )
}

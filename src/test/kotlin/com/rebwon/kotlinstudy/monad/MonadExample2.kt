package com.rebwon.kotlinstudy.monad

fun a(value: Int): Result<Int> {
    return if (value > 0) {
        Result.Success(value * 10)
    } else {
        Result.Fail()
    }
}

fun b(value: Result<Int>): Result<Int> {
    return when (value) {
        is Result.Success -> Result.Success(value.value * 10)
        is Result.Fail -> value
    }
}

fun c(value: Result<Int>): Int {
    return when (value) {
        is Result.Success -> value.value
        is Result.Fail -> -1
    }
}

fun d(value: Int): Int {
    return value * 10
}

infix fun <T> Result<T>.compose(functor: (value: Result<T>) -> Result<T>): Result<T> {
    return functor(this)
}

infix fun <T> Result<T>.compose2(functor: (value: Result<T>) -> T): T {
    return functor(this)
}

fun main() {
    // before
    val result1 = c(b(b(b(b(a(10))))))
    println(result1)

    val result2 = c(b(b(b(b(a(-10))))))
    println(result2)

    // after
    val result3 = a(10) compose ::b compose ::b compose ::b compose ::b compose2 ::c
    println(result3)

    val result4 = a(-10) compose ::b compose ::b compose ::b compose ::b compose2 ::c
    println(result4)
}
package com.rebwon.kotlinstudy.monad

fun div(a: Int, b: Int): Result<Int> {
    return try {
        Result.Success(a / b)
    } catch (e: Exception) {
        Result.Fail()
    }
}

fun main(args: Array<String>) {
    val result1 = div(10, 2)
    val result2 = div(10, 0)

    when (result1) {
        is Result.Success -> println(result1.value)
        is Result.Fail -> println("result1 is failed")
    }

    when (result2) {
        is Result.Success -> println(result2.value)
        is Result.Fail -> println("result2 is failed")
    }
}

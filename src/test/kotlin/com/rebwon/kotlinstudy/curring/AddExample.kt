package com.rebwon.kotlinstudy.curring

class AddExample {
}

fun main(args: Array<String>) {
    val op10Plus = operator(10) { a, b -> a + b }
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = numbers.map { op10Plus(it) }
    println(result)
}

fun <T> operator(a: T, op: (T, T) -> T): (T) -> T {
    return { b -> op(a, b) }
}
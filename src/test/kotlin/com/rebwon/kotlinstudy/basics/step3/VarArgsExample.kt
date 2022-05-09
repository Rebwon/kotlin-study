package com.rebwon.kotlinstudy.basics.step3

fun main(args: Array<String>) {
    val list = listOf("args:", *args)
    println(list)

    val map = mapOf(1 to "one", 2 to "two", 53 to "fifty-three")
    val (number, name) = 1 to "one"
    println("$number: $name")
}

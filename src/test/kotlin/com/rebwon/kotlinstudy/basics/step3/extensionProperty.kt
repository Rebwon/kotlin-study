package com.rebwon.kotlinstudy.basics.step3

val String.something : Char
    get() = get(length - 1)

fun main() {
    val result = "Hello World".something
    println(result)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}

var StringBuilder.lastChar : Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

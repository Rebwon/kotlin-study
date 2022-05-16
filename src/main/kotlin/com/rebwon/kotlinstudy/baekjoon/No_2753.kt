package com.rebwon.kotlinstudy.baekjoon

fun main() {
    val year = readLine()!!.toInt()
    when {
        year % 4 == 0 && year % 100 != 0 -> println("1")
        year % 400 == 0 -> println("1")
        else -> println("0")
    }
}

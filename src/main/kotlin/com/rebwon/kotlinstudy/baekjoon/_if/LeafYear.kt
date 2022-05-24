package com.rebwon.kotlinstudy.baekjoon._if

import com.rebwon.kotlinstudy.baekjoon.bufferedReader

fun main() {
    val reader = bufferedReader()
    val year = reader.readLine().toInt()
    if (year % 4 == 0) when {
        year % 400 == 0 -> println("1")
        year % 100 == 0 -> println("0")
        else -> println("1")
    } else println("0")
}

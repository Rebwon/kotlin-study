package com.rebwon.kotlinstudy.baekjoon._for

import com.rebwon.kotlinstudy.baekjoon.bufferedReader

fun main() {
    val reader = bufferedReader()
    val number = reader.readLine().toInt()

    for (i in 1..9) {
        println("$number * $i = ${number * i}")
    }
}

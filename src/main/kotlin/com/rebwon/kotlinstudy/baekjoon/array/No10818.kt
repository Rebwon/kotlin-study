package com.rebwon.kotlinstudy.baekjoon.array

import com.rebwon.kotlinstudy.baekjoon.bufferedReader

fun main() {
    val reader = bufferedReader()
    val count = reader.readLine().toInt()
    val array = reader.readLine().split(" ")
        .map { it.toInt() }
        .sorted()
        .toIntArray()

    println("${array[0]} ${array[count - 1]}")
}

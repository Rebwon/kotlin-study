package com.rebwon.kotlinstudy.baekjoon._for

import com.rebwon.kotlinstudy.baekjoon.bufferedReader

fun main() {
    val reader = bufferedReader()
    val (count, conditionNumber) = reader.readLine().split(" ")
    reader.readLine().split(" ")
        .forEach {
            if (conditionNumber.toInt() > it.toInt()) print(it.toInt())
        }
}

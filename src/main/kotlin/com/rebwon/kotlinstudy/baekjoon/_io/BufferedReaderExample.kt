package com.rebwon.kotlinstudy.baekjoon._io

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val a = reader.read()
//    println(a)
//    println(a - 48)
    val values = reader.readLine().split(" ")
    println(values[0].toInt() + values[1].toInt())
}

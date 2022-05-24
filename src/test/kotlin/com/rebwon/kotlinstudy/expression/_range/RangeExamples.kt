package com.rebwon.kotlinstudy.expression._range

fun main() {
    val i = 3
    if (i in 1..4) {
        // i가 1과 4 사이에 포함된 경우
        println(i)
    }
    for (j in 0..8) print(j)
    println()
    for (j in 1..4) print(j)
    println()
    for (j in 4 downTo 1) print(j)
    println()
    for (j in 1..8 step 2) print(j)
    println()
    for (j in 8 downTo 1 step 2) print(j)
    println()
    for (j in 1 until 10) print(j)
}

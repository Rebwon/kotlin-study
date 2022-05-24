package com.rebwon.kotlinstudy.baekjoon._for

fun main() {
    for (i in 1..5) {
        println("*".repeat(i))
    }

    for (i in 1..5) {
        for (j in 1..5 - i) {
            print(" ")
        }
        for (k in 1..i) {
            print("*")
        }
        print("\n")
    }
}

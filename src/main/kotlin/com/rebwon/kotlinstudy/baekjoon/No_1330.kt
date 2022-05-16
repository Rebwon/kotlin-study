package com.rebwon.kotlinstudy.baekjoon

fun main() {
    val numbers = readLine()!!.split(" ")
    val firstNumber = numbers[0].toInt()
    val secondNumber = numbers[1].toInt()

    println(no1330(firstNumber, secondNumber))
}

fun no1330(firstNumber: Int, secondNumber: Int) =
    when {
        firstNumber > secondNumber -> ">"
        firstNumber < secondNumber -> "<"
        else -> "=="
    }

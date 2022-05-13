package com.rebwon.kotlinstudy.basics.step5

import java.io.File

fun main() {

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

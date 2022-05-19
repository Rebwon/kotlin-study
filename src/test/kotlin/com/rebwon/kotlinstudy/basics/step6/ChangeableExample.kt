package com.rebwon.kotlinstudy.basics.step6

import com.rebwon.kotlinstudy.CollectionUtils

fun main() {
    val list = listOf("a", "b", "c")
    printableUppercase(list)

    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString())

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))
}

fun printableUppercase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}

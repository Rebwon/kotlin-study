package com.rebwon.kotlinstudy.baekjoon._io

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    println("Hello World!")

    val sb = StringBuilder()
    sb.append("Hello World!\n")
    println(sb.toString())

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("Hello World!")
    bw.flush()
    bw.close()
}

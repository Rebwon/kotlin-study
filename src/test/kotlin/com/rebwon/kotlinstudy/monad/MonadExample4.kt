package com.rebwon.kotlinstudy.monad

import java.io.File

fun main() {
    testOptional()
}

fun testOptional() {

    fun openFile(fileName: String): Optional<File> {
        return try {
            Optional.Some(File(fileName))
        } catch (e: Exception) {
            Optional.None()
        }
    }

    fun readFile(file: File): Optional<String> {
        return try {
            Optional.Some(file.inputStream().bufferedReader().use { it.readText() })
        } catch (e: Exception) {
            Optional.None()
        }
    }

    when (val content = openFile("greeting.txt") flatMap ::readFile) {
        is Optional.Some -> println(content.value)
        is Optional.None -> println("File not found")
    }
}

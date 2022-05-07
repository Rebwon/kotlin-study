package com.rebwon.kotlinstudy.monad

import java.io.File
import java.io.FileNotFoundException

fun main() {
    testEither()
}

fun testEither() {
    fun openFile(fileName: String): Either<Throwable, File> {
        return try {
            val file = File(fileName)
            if (file.exists()) {
                Either.Right(file)
            } else {
                Either.Left(FileNotFoundException())
            }
        } catch (e: Throwable) {
            Either.Left(e)
        }
    }

    fun readFile(file: File): Either<Throwable, String> {
        return try {
            Either.Right(file.inputStream().bufferedReader().use {it.readText()})
        } catch (e: Throwable) {
            Either.Left(e)
        }
    }

    when(val content = openFile("greeting.txt") flatMap :: readFile) {
        is Either.Right -> println(content.value)
        is Either.Left -> println(content.value)
    }
}
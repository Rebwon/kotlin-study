package com.rebwon.kotlinstudy.basics.step7

import java.math.BigDecimal

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1[1])
    println(p1 + p2)
    println(p1 - p2)
    println(p1 * 1.5)
    println('a' * 3)

    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])
    var bigDecimal = BigDecimal.ZERO
    println(++bigDecimal)
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

package com.rebwon.kotlinstudy.basics.step2

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gladstone"
    Color.BLUE -> "Buckingham"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vale"
}

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Does not mix")
}

fun mixOptimized(c1: Color, c2: Color) = when {
    c1 == Color.RED && c2 == Color.YELLOW -> Color.ORANGE
    c1 == Color.YELLOW && c2 == Color.BLUE -> Color.GREEN
    c1 == Color.BLUE && c2 == Color.VIOLET -> Color.INDIGO
    else -> throw Exception("Does not mix")
}

fun main() {
    println(mix(Color.YELLOW, Color.BLUE))
}

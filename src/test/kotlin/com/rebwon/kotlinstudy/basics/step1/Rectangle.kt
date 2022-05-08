package com.rebwon.kotlinstudy.basics.step1

class Rectangle(val width: Int, val height: Int) {
    val isSquare: Boolean
        get() = width == height
}

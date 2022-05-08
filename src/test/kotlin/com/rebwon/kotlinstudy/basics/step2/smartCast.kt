package com.rebwon.kotlinstudy.basics.step2

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun main() {
//    println("식의 합계 : ${eval(Sum(Sum(Num(1), Num(2)), Num(4)))}")
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

fun evalWithLogging(e: Expr): Int = when(e) {
    is Num -> {
        println("Num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("Sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown expression")
}

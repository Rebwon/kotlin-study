package com.rebwon.kotlinstudy.basics

class Rectangle(val height: Int, val width: Int) {
    fun area() = height * width
}

data class AuthenticatedUser(val id: Long, val roles: List<String>)

package com.rebwon.kotlinstudy.basics.step6

fun main() {

    var email: String? = "msolo021015@gmail.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

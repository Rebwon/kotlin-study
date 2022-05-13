package com.rebwon.kotlinstudy.messaging

internal open class Happy {

    protected fun happy() {}

    class HappyImpl : Happy() {

        fun happy2() {
            happy()
        }
    }
}

fun main() {
    val happy = Happy()
    // happy.happy() Compile Error.
}

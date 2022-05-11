package com.rebwon.kotlinstudy.basics.step4

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client(name='$name', postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

fun main() {
    val client = Client("John", 12345)
    println(client)

    val client1 = Client("John", 12345)
    val client2 = Client("John", 12345)
    println(client1 == client2)
}

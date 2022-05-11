package com.rebwon.kotlinstudy.basics.step4

interface Account {
    val nickname: String
        get() = "Rebwon"
}

class PrivateAccount(override val nickname: String) : Account

class SubscribingAccount(val email: String) : Account {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookAccount(accountId: Int) : Account {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        TODO("Not yet implemented")
    }
}

class User3(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value"
                """.trimIndent()
            )
            field = value
        }
}

fun main() {
    val user = User3("Rebwon")
    user.address = "Seoul Korea"
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

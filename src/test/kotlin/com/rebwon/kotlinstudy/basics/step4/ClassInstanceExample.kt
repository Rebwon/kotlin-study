package com.rebwon.kotlinstudy.basics.step4

class User constructor(_nickname: String) {
    private val nickname: String

    // _nickname은 init {}이나 nickname 프로퍼티에
    // 바로 할당할 때만 참조 가능하다.
    init {
        nickname = _nickname
    }
}

class User1(_nickname: String) {
    private val nickname = _nickname
}

// 이렇게 하면 주 생성자에서 파라미터의 할당과 동시에 nickname 값이 초기화된다.
class User2(val nickname: String, val isSubscribed: Boolean = true)

open class PrivateUser(val nickname: String)

class SubscribingUser(nickname: String) : PrivateUser(nickname)

interface Something

class SomethingImpl : Something

open class Wrong()

class WrongImpl : Wrong()

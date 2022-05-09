package com.rebwon.kotlinstudy.basics.step3

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Empty name : ${user.name}")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Empty address : ${user.address}")
    }
}

fun saveUserLocal(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty())
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUserLocalV2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty())
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

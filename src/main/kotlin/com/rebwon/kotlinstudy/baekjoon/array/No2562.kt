package com.rebwon.kotlinstudy.baekjoon.array

import com.rebwon.kotlinstudy.baekjoon.bufferedReader

fun main() {
    val reader = bufferedReader()
    val intArr = arrayOfNulls<Int>(8)
    for (index in 0..8) {
        intArr[index] = reader.readLine().toInt()
    }

    var max = 0
    var count = 0
    intArr.forEachIndexed { index, value ->
        value?.let {
            if (it > max) {
                max = it
                count = index
            }
        }
    }
    print("$max $count")
}

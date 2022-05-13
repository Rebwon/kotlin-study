package com.rebwon.kotlinstudy.basics.step3

fun String.lastChar() = this[this.length - 1]

fun main() {
    println("Hello, world".lastChar())

    val list = listOf("a", "b", "c")
    println(list.joinToString())

    var view = View()
    view.click()
    view = Button()
    view.click()

    view.disabled()
    view = View()
    view.disabled()
    view.showOpen()
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 확장함수는 오버라이딩 되지 않는다. static dispatch.
// 동일한 시그니처를 가진 멤버 함수와 확장 함수가 있다면
// 호출 우선 순위는 멤버 함수이다.
open class View {
    open fun click() = println("View Clicked")
    fun showOpen() = println("Show Opened")
}

fun View.disabled() {
    println("View disabled")
}

fun View.showOpen() {
    println("Show Opened!!")
}

class Button : View() {
    override fun click() = println("Button Clicked")
}

fun Button.disabled() {
    println("Button disabled")
}

// With Java
/**
 * View view = new Button()
 * ExtensionFuncKt.disabled(view)
 * -> View Disabled
 */

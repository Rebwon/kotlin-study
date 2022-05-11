package com.rebwon.kotlinstudy.basics.step4

interface State : java.io.Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Button1 : View {
    override fun getCurrentState(): State {
        return ButtonState()
    }

    override fun restoreState(state: State) {
        // do nothing
    }

    class ButtonState : State
}

class Outer {

    inner class Inner {

        fun getOuterReference(): Outer = this@Outer
    }
}

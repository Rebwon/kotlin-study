package com.rebwon.kotlinstudy.messaging

import org.springframework.stereotype.Component

@Component
private class MessageAdapterImpl : MessageAdapter {
    override fun adaptive() {
        println("Called Message Adapter")
    }
}

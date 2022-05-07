package com.rebwon.kotlinstudy.monad

import java.util.concurrent.Executors

typealias Callback<Err, T> = (Either<Err, T>) -> Unit

interface Scheduler {
    fun execute(command: () -> Unit)
    fun shutdown()
}

object SchedulerIO: Scheduler {
    private var executorService = Executors.newFixedThreadPool(1)
    override fun execute(command: () -> Unit) {
        if (executorService.isShutdown) {
            executorService = Executors.newFixedThreadPool(1)
        }
        executorService.execute(command)
    }

    override fun shutdown() {
        if (!executorService.isShutdown) {
            executorService.shutdown()
        }
    }
}

object SchedulerMain: Scheduler {
    override fun execute(command: () -> Unit) {
        Thread(command).start()
    }

    override fun shutdown() = Unit
}
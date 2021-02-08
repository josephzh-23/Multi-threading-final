package Waiter__Notifier__Copy2

import java.util.*

class Processor {

    private var lock = java.lang.Object()

    private var state = "tick"

    @Throws(InterruptedException::class)
    fun produce() {
        synchronized(lock) {

                println("Producer thread running ....")
                state = "tock"
                lock.notify()

            while(state!="tick") {
                lock.wait()
            }

        }
    }

    @Throws(InterruptedException::class)
    fun consume() {
        synchronized(lock) {
                println("Consumer thread is running.")
                state = "tick"
                lock.notify()

            while(state!="tock") {
                lock.wait()
            }
            Thread.sleep(1000)
        }

    }
}
package Waiter__Notifier

import java.util.*

class Processor {

    private var lock = java.lang.Object()


    @Throws(InterruptedException::class)
    fun produce() {
        synchronized(lock) {
            println("Producer thread running ....")
            lock.wait()
            println("Resumed.")
        }
    }

    @Throws(InterruptedException::class)
    fun consume() {
        val scanner = Scanner(System.`in`)
        Thread.sleep(2000)
        synchronized(lock) {
            println("Waiting for return key.")
            scanner.nextLine()
            println("Return key pressed.")
            lock.notify()
            Thread.sleep(1000)
        }
    }
}
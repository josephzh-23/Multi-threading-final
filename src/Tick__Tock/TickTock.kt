package Tick__Tock

internal class TickTock {

    var state // contains the state of the clock
            : String? = null

    private var lock = java.lang.Object()


        fun tick(running: Boolean) {
            synchronized(lock)
            {
            if (!running) { // stop the clock
                state = "ticked"
                lock.notify() // notify any waiting threads
                return
            }

            print("Tick ")
            state = "ticked" // set the current state to ticked
            lock.notify() // let tock() run

            try {
                while (state != "tocked")
                    lock.wait() // wait for tock() to complete
            } catch (exc: InterruptedException) {
                println("Thread interrupted.")
            }
        }
    }

    fun tock(running: Boolean) {
        synchronized(lock) {
            if (!running) { // stop the clock
                state = "tocked"
                lock.notify() // notify any waiting threads
                return
            }
            println("Tock")
            state = "tocked" // set the current state to tocked
            lock.notify() // let tick() run
            try {
                while (state != "ticked")
                    lock.wait() // wait for tick to complete
            } catch (exc: InterruptedException) {
                println("Thread interrupted.")
            }
        }
    }
}
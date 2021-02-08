internal class createAndStart(name: String?) : Runnable {
    var thrd: Thread

    // Entry point of thread.
    override fun run() {
        println(thrd.name + " starting.")
        try {
            for (count in 0..9) {
                Thread.sleep(400)
                println(
                    "In " + thrd.name +
                            ", count is " + count
                )
            }
        } catch (exc: InterruptedException) {
            println(thrd.name + " interrupted.")
        }
        println(thrd.name + " terminating.")
    }


    // A generic way to start the thread here
    companion object {
        // A factory method that creates and starts a thread.
        fun createAndStart(name: String?): createAndStart {
            val myThrd = createAndStart(name)
            myThrd.thrd.start() // start the thread
            return myThrd
        }
    }

    // Construct a new thread using this Runnable and give
    // it a name.
    init {
        thrd = Thread(this, name)
    }
}
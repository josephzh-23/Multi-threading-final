package Tick__Tock

internal class MyThread(name: String?, tt: TickTock) : Runnable {
    var thrd: Thread
    var ttOb: TickTock

    // Entry point of thread.
    override fun run() {

        //If thread name is tock

        // 5 calls that pass true as an argument are made to each thread
        //The clock runs as long as true is passed
        if (thrd.name.compareTo("Tick") == 0) {
            for (i in 0..5) ttOb.tick(true)

            // A final call to false stops the clock
            ttOb.tick(false)

            //If thread name is tock
        } else {

            for (i in 0..5) ttOb.tock(true)
            ttOb.tock(false)
        }
    }

    companion object {
        // A factory method that creates and starts a thread.
        fun createAndStart(name: String?, tt: TickTock): MyThread {
            val myThrd = MyThread(name, tt)
            myThrd.thrd.start() // start the thread
            return myThrd
        }
    }


    // Construct a new thread.
    init {
        thrd = Thread(this, name)
        ttOb = tt
    }
}

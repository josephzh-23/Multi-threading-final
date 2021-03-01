package Custom_Executor


// Our runnable class
class Execution : Runnable{


    // Used to start new runnable
    fun executeMyMethod() {

        if (MyThreadPool.currentCapacity < MyThreadPool.capacity) {

            MyThreadPool.currentCapacity++
            val t = Thread(Execution())
            t.start()
        }
    }

    override fun run() {
        while (true) {
            if (MyThreadPool.linkedBlockingQueue.size != 0) {

                // Poll will remove from head of tail, the runnable

                MyThreadPool.linkedBlockingQueue.poll().run()
            }
        }
    }

}
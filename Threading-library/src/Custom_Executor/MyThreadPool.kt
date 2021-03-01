package Custom_Executor

import java.util.concurrent.LinkedBlockingQueue

class MyThreadPool(capacity: Int) : MyExecutorService {
    var e: Execution

    // Add the runnabe to the queue
    override fun submit(r: Runnable) {
        linkedBlockingQueue.add(r)
        e.executeMyMethod()
    }

    var companion = Companion
    companion object {
        var capacity: Int = 0
        var currentCapacity: Int = 6
        lateinit var linkedBlockingQueue: LinkedBlockingQueue<Runnable>
    }

    init {
        companion.capacity = capacity
        currentCapacity = 0
        linkedBlockingQueue = LinkedBlockingQueue()
        e = Execution()
    }
}
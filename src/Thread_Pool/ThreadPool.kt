package MultiThreading.Thread_Pool

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Processor(private val id: Int) : Runnable {
    override fun run() {
        println("Starting: $id")
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
        }
        println("Completed: $id")
    }

}


object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val executor: ExecutorService = Executors.newFixedThreadPool(2)
        for (i in 0..4) {
            executor.submit(Processor(i))
        }
        executor.shutdown()
        println("All tasks submitted.")
        try {
            executor.awaitTermination(1, TimeUnit.DAYS)
        } catch (e: InterruptedException) {
        }
        println("All tasks completed.")
    }
}
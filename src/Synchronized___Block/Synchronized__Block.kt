package Synchronized___Block

// With this we
// lock the sumArray function in SumArray class 
// And thread 1 will run first and then thread 2


// Use a synchronized block to control access to SumArray class
// and its method
class SumArray() {
    private var sum = 0

    // Can only be accessed by 1 thread
    fun sumArray(nums: IntArray): Int {
        sum = 0 // reset sum
        for (i in nums.indices) {
            sum += nums[i]
            println(
                "Running total for " +
                        Thread.currentThread().name +
                        " is " + sum
            )
            try {
                Thread.sleep(1000) // allow task-switch
            } catch (exc: InterruptedException) {
                println("Thread interrupted.")
            }
        }
        return sum
    }
}

class MyThread(name: String?, nums: IntArray?) : Runnable {
    //    lateinit var thrd: Thread
    var a: IntArray? = nums
    var answer = 0

    //Only 1 copy to be shared between all instances
    companion object {
        var sa = SumArray()
    }
    // Entry point of thread.
    override fun run() {
        var sum: Int
        println(  " starting ${Thread.currentThread().name}")


        //Synchrnoized block here, we lock the object here
        synchronized(sa) {
            answer = sa.sumArray(a!!)
        }
        println(
            "Sum for  ${Thread.currentThread().name}" +
                    " is " + answer
        )
        println("${Thread.currentThread().name} + terminating.")
    }



}


internal object Sync {
    @JvmStatic
    fun main(args: Array<String>) {
        var a = intArrayOf(1, 2, 3, 4, 5)

        // 2 runnables for the same thread runnable
        val mt1: MyThread = MyThread("Child #1", a)
        val mt2: MyThread = MyThread("Child #2", a)
        val t1 = Thread(mt1)

        val t2 = Thread(mt2)
        try {
            t1.start()
            t2.start()
            t1.join()
            t2.join()
        } catch (exc: InterruptedException) {
            println("Main thread interrupted.")
        }
    }
}






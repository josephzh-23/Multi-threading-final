package MultiThreading.Multipe_Locks

import java.util.*



//Lesson 4 code

/*

2 processes are running here
with 2 threads

Notice there are 2 locks used here
 So we can access 1 function with 1 thread

 while accesing the other 1 function wit the other thread.
*/
class Worker {
    private val random = Random()
    private val lock1 = Any()
    private val lock2 = Any()
    private val list1: MutableList<Int> = ArrayList()
    private val list2: MutableList<Int> = ArrayList()

    //Add sth to list 1
    fun stageOne() {
        synchronized(lock1) {
            try {
                Thread.sleep(1)
            } catch (e: InterruptedException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            list1.add(random.nextInt(100))
        }
    }

    fun stageTwo() {

        // Only 1 mthd accessing
        synchronized(lock2) {
            try {
                Thread.sleep(1)
            } catch (e: InterruptedException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            list2.add(random.nextInt(100))
        }
    }

    fun process() {
        for (i in 0..999) {
            stageOne()
            stageTwo()
        }
    }

    fun main() {
        println("Starting ...")
        val start = System.currentTimeMillis()
        val t1 = Thread(Runnable { process() })
        val t2 = Thread(Runnable { process() })
        t1.start()
        t2.start()
        try {
            t1.join()
            t2.join()
        } catch (e: InterruptedException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        val end = System.currentTimeMillis()
        println("Time taken: " + (end - start))
        println("List1: " + list1.size + "; List2: " + list2.size)
    }
}

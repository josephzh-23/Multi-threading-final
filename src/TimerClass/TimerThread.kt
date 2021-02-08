package MultiThreading.TimerClass

import java.util.*


//THis will run in the background
//And start the timer
//And then stop the timer

class TimerThread(var running: Boolean): Runnable {

    @Volatile
    var count = 0
    @Volatile
    var count2 = 0

    //Make a timer class in here
    val timer =Timer()

    //The task to be run every 1 second
    val task = object: TimerTask() {
        override fun run() {

            count++
            println("timer is currently $count")
        }
    }

    // This wil start the timer at 1 sec fixed-repeat rate
    fun start() {
        timer.schedule(task, 0, 1000)
    }
    fun cancel(){
        timer.cancel()
    }


    //Fxn will stop running when runnning = false,
    //Otherwise will keep going
        override fun run() {
            while(running) {

                count2++
                println("The current time is $count")
            }
        }


}








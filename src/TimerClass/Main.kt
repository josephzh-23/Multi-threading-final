package MultiThreading.TimerClass

import java.util.*


//The class that represents our task
internal class EatPeopleTask : TimerTask() {
    override fun run() {
        println("*eat all the people*")
        println("End of task.")
    }
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val task = EatPeopleTask()
        val timer = Timer()
        timer.schedule(task, 5000)
        //Executes task 5 seconds after the program starts

        //remember, the timer is a thread that is running concurrent with the main thread of the program
        try {
            Thread.sleep(5000) //After the timer starts, pause the main thread for 5 seconds
        } catch (exc: InterruptedException) {
        }
        timer.cancel()

        //then end the program because the thread
        // is done so there is nothing else to do
    }
}
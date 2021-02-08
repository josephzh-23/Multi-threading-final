package Tick__Tock

internal object ThreadCom {
    @JvmStatic
    fun main(args: Array<String>) {
        val tt = TickTock()
        val mt1 = MyThread.createAndStart("Tick", tt)
        val mt2 = MyThread.createAndStart("Tock", tt)


        try {
            mt1.thrd.join()
            mt2.thrd.join()
        } catch (exc: InterruptedException) {
            println("Main thread interrupted.")
        }
    }
}
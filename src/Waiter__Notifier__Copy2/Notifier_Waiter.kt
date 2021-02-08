package Waiter__Notifier__Copy2

object App {
    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val processor = Processor()
        val t1 = Thread {
            try {
                for (i in 0..10) {
                    processor.produce()
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        val t2 = Thread {
            try {
                for (i in 0..10) {
                    processor.consume()
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        t1.start()
        t2.start()

        //Non need to call join if you dont want to block the main UI thread
        t1.join()
        t2.join()
    }
}
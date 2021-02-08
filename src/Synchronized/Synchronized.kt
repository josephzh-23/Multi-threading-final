//package MultiThreading.Synchronized
//
//class Worker {
//    private var count = 0
//
//
//    //Using synchronized key word here
//    @Synchronized
//    fun increment() {
//        count++
//    }
//
//    fun run() {
//        val thread1 = Thread(Runnable {
//            for (i in 0..9999) {
//                increment()
//            }
//        })
//        thread1.start()
//        val thread2 = Thread(Runnable {
//            for (i in 0..9999) {
//                increment()
//            }
//        })
//        thread2.start()
//        try {
//            thread1.join()
//            thread2.join()
//        } catch (e: InterruptedException) {
//            // TODO Auto-generated catch block
//            e.printStackTrace()
//        }
//        println("Count is: $count")
//    }
//}
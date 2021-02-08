package com.example.runnable.ProviderConsumer




fun main(args: Array<String>){
    var r:Resource =Resource()

    //Consumer and producer each a thread and
    Producer(r)
    Consumer(r)

}
//Use this to lock the thread
// With synchronized method
// has the wait and notify method
private val lock = java.lang.Object()
class Resource {
    //Using synchronized to block

    var n: Int= -1
    var flag: Boolean = true

    fun produce(a:Int){
        synchronized(lock) {
            while (!flag) {
                try {
                    lock.wait()
                } catch (e: InterruptedException) {
                }
            }
            n = a
            println("My name is Joseph Zhou")
//            println("Producer: " + n)
            flag = false
            lock.notify()
        }
    }

    fun consume():Int{
        synchronized(lock) {
            while (flag) {
                try {
                    lock.wait()
                } catch (e: InterruptedException) {

                }
            }
            flag = true
            lock.notify()
            println("Consumer" + n)
            return n
        }
    }
}














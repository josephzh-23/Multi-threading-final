package com.example.runnable.ProviderConsumer


class Producer: Runnable {
    var s: Resource
    var t: Thread

    constructor(r: Resource) {
        s = r
        t = Thread(this, "Producer")
        t.start()
    }
    override fun run() {
        for (i in 1..10) {
            try {
                Thread.sleep(300)
            } catch (e: InterruptedException) {
            }
            s.produce(i)
        }
        println("Producer ending")
    }
}


package com.example.runnable.ProviderConsumer



class Consumer: Runnable {
    var s: Resource
    var t: Thread

    constructor(r: Resource) {
        s = r
        t = Thread(this, "Producer")
        t.start()
    }

    override fun run() {
        var i: Int
        do {
            try {
                Thread.sleep(300)
            } catch (e: InterruptedException) {
            }
            i = s.consume()
        }while(i!=10)
            println("Consumer ending")

    }
}


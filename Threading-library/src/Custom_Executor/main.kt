package Custom_Executor


    fun main(args:Array<String>){
        val service: MyExecutorService = MyExecutors.myNewFixedThreadPool(5)
        for (i in 0..19) {
            service.submit(Runnable(){
                println("joseph")
            })
        }
    }
package Custom_Executor


// Used to initialize thread capacity
class MyExecutors {

    companion object{
        fun myNewFixedThreadPool(capacity: Int): MyThreadPool {
          return  MyThreadPool(capacity)
        }
    }
}
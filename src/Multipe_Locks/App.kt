package MultiThreading.Multipe_Locks


object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val worker = Worker()
        worker.main()
    }
}

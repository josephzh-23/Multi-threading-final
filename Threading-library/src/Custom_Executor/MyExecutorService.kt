package Custom_Executor

internal interface MyExecutorService {
    fun submit(r: Runnable)
}

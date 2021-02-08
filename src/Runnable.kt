package MultiThreading

fun main(args:Array<String>){
    var a =A()
    var t1 = Thread(a, "joseph")
    var t2 = Thread(a, "eric")

    t1.start()
    t2.start()
}
class A: Runnable
{

    override fun run(){

        for (i in 1..3){

            println(Thread.currentThread().name)
        }
    }
}

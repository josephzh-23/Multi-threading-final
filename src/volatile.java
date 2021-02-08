import java.lang.invoke.VarHandle;

class VolatileThread extends Thread{



    public static void main(String[] args) throws Exception {


    }

}



class VolatileData {
    private volatile int counter;

    public VolatileData(int counter) {
        this.counter = counter;
    }

    public int getCounter()
    {
        return counter;
    }
    public void increaseCounter()
    {
        ++counter;      //increases the value of counter by 1
    }
}


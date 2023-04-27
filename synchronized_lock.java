class Loop{
    public static Object lock = new Object();

    public static void printLoop(int x, String s){
        // below lock will not work because lock need to be shared between the threads.
        // Here each thread will create its own lock
        // Object lock = new Object();
        synchronized(lock){
            for(int i = 0; i<x; i++){
                String thread_name = Thread.currentThread().getName();
                System.out.println(i + ", Background id : " + s + ", Thread Name : " + thread_name);
            }
        }
    }
}

class BackgroundWorker implements Runnable{
    private int id;
    public BackgroundWorker(int x){
        this.id = x;
    }

    public void run(){
        Loop.printLoop(5, Integer.toString(id));
    }
}


public class synchronized_lock {
    public static void main(String[] args) {
        BackgroundWorker w1 = new BackgroundWorker(0);
        BackgroundWorker w2 = new BackgroundWorker(1);
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        t1.start();
        t2.start();
    }
}

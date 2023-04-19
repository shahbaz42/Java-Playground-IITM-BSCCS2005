class Parallel implements Runnable {
    private int id;
    public Parallel(int x) {
        id = x;
    }
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("Thread " + id + " is running");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // print stack trace exception
                e.printStackTrace();
                System.out.println("Thread " + id + " is interrupted");
            }
        }
    }
}

public class Threads_using_Runnable_interface {
    public static void main(String[] args) {
        Parallel[] p = new Parallel[5];
        Thread[] t = new Thread[5];
        for(int i = 0; i<5; i++){
            p[i] = new Parallel(i);
            t[i] = new Thread(p[i]);
            t[i].start();
        }
    }
}

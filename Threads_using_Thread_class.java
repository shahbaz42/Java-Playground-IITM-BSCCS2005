class Parallel extends Thread {
    private int id;
    public Parallel(int x) {
        id = x;
    }
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("Thread " + id + " is running");
            try {
                sleep(1000);
            } catch (Exception e) {
                // print stack trace exception
                e.printStackTrace();
                System.out.println("Thread " + id + " is interrupted");
            }
        }
    }
}

public class Threads_using_Thread_class {
    public static void main(String[] args) {
        Parallel[] p = new Parallel[5];
        for(int i=0; i<5; i++){
            p[i] = new Parallel(i);
            p[i].start();
        }
    }
}

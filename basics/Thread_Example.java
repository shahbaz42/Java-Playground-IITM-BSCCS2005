class SampleClass implements Runnable {
    int x = 5;
    public void get() {
        System.out.println(x);
    }
    public void run() {
        System.out.println("Inside Thread from SampleClass");
        for(int i = 0; i < 10; i++)
            System.out.println(i);
    }
}

public class Thread_Example implements Runnable {
    public static void main(String[] args) {
        Thread_Example obj = new Thread_Example();
        Thread thread = new Thread(obj);
        thread.start();

        SampleClass obj2 = new SampleClass();
        Thread thread2 = new Thread(obj2);
        thread2.start();



        System.out.println("Outside Thread");
    }
    public void run() {
        System.out.println("Inside Thread");
        for(int i = 0; i < 5; i++)
            System.out.println(i);
    }
}

interface Incrementable {
    public void increment();
}

class Counter implements Incrementable {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class SynchronizedCounter implements Incrementable{
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

class Worker<T extends Incrementable> implements Runnable {
    private T counter;

    public Worker(T counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment(); // Line 1
        }
    }
}

public class monitor_demo {
    public static void main(String[] args) throws InterruptedException {
        // Counter
        Counter counter = new Counter();

        Worker<Counter> worker1 = new Worker<>(counter); 
        Worker<Counter> worker2 = new Worker<>(counter); 

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final count: " + counter.getCount());

        // SynchronizedCounter
        SynchronizedCounter syncCounter = new SynchronizedCounter();

        Worker<SynchronizedCounter> worker3 = new Worker<>(syncCounter);
        Worker<SynchronizedCounter> worker4 = new Worker<>(syncCounter);

        Thread thread3 = new Thread(worker3);
        Thread thread4 = new Thread(worker4);

        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();

        System.out.println("Final count (Synchronized) : " + syncCounter.getCount());

    }
}

/*
    Output : 
    Final count: 1583
    Final count (Synchronized) : 2000
*/

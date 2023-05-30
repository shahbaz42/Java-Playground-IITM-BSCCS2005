interface Callback{
    public void callback();
}

class TimerOwner implements Callback{
    public void callback(){
        System.out.println("Recieved a callback, TImer End");
    }
}

class Timer implements Runnable{
    private TimerOwner owner;
    private int duration;
    public Timer(int duration, TimerOwner owner){
        this.owner = owner;
        this.duration = duration;
    }
    public void run(){
        System.out.println("Timer has started.");
        try{
            Thread.sleep(duration);
            owner.callback();
        }
        catch(InterruptedException e){
            System.out.println("InterruptedException.");
        }
    }
}

public class async_callback {
    public static void main(String[] args) {
        TimerOwner parentFunction = new TimerOwner();
        Timer t1 = new Timer(5000, parentFunction);
        Thread th1 = new Thread(t1);
        System.out.println("Starting a timer in background.");
        th1.start();
        System.out.println("Doing other Stuff.");
        System.out.println("Timer is expected to end soon.");
    }
}

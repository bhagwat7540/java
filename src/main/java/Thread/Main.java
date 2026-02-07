package Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedObj sharedObj = new SharedObj();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sharedObj.outerMethod();
            }
        };

        Thread t1 = new Thread(runnable, "T1");
        Thread t2 = new Thread(runnable, "T2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

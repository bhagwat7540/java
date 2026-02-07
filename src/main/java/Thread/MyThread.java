package Thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("HI");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        t1.interrupt();
        System.out.println("main end");
    }
}

package Thread.ProducerConsumer;

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedObject obj = new SharedObject();
        Thread t1 = new Thread(new Producer(obj), "T1");
        Thread t2 = new Thread(new Consumer(obj), "T2");

        t1.start();
        t2.start();
    }
}

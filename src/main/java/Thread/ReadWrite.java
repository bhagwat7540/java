package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private int count = 0;

    public int read() {
        readLock.lock();
        try {
            return count;
        }
        finally {
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        count++;
        writeLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWrite obj = new ReadWrite();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<10 ; i++) {
                    System.out.println(Thread.currentThread().getName() + " - read - " + obj.read());
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<10 ; i++) {
                    obj.write();
                    System.out.println(Thread.currentThread().getName() + " - write incremented");
                }
            }
        };

        Thread t1 = new Thread(task1, "T1");
        Thread t2 = new Thread(task1, "T2");
        Thread t3 = new Thread(task2, "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }


}

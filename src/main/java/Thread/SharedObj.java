package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Reentrant lock is for shared object
public class SharedObj {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - Outer Method");
                Thread.sleep(3000);
                innerMethod();
            } catch (Exception e) {}
            finally {
                lock.unlock();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " - cant acquire lock");
        }
    }

    public void innerMethod() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - Inner Method");
                Thread.sleep(2000);
            } catch (Exception e){}
            finally {
                lock.unlock();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " - cant acquire lock");
        }
    }
}

package Thread.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {
    private final CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
            System.out.println("Service starting ");
            return "HELLO WORLD!";
        }finally {
            countDownLatch.countDown();
        }
    }
}

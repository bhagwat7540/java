package Thread.Executor;

import java.util.concurrent.*;

public class StartupExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Future<String> future1 = executorService.submit(new Task(countDownLatch));
        Future<String> future2 = executorService.submit(new Task(countDownLatch));
        Future<String> future3 = executorService.submit(new Task(countDownLatch));

        try {
            countDownLatch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executorService.shutdown();
        System.out.println("Starting main");
    }
}

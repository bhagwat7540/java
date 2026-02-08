package Thread.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();

        for(int i=1 ; i<9 ; i++) {
            int finalI = i;
            Future<Long> future = executorService.submit(()->{
                long ans = factorial(finalI);
                System.out.println(ans);
                return ans;
            });

//            try {
//                future.get();
//            }catch (Exception e){} -- adds a wait here to get response
        }

        executorService.shutdown();

        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Time taken : " + (System.currentTimeMillis()-startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long ans = 1;
        for(int i=1 ; i<=n ; i++) {
            ans *= i;
        }

        return ans;
    }
}

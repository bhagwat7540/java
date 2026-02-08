package Thread.Executor;

import java.util.List;
import java.util.concurrent.*;

public class Invoke {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Integer> callable1 = ()->{
            System.out.println("TASK 1");
            return 1;
        };
        Callable<Integer> callable2 = ()->{
            System.out.println("TASK 2");
            return 2;
        };
        Callable<Integer> callable3 = ()->{
            System.out.println("TASK 3");
            return 3;
        };

        List<Callable<Integer>> list = List.of(callable1, callable2, callable3);

        try {
            List<Future<Integer>> ans = executorService.invokeAll(list);
            for(Future<Integer> future: ans) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e){

        }

        executorService.shutdown();
        System.out.println("DONE");
    }
}

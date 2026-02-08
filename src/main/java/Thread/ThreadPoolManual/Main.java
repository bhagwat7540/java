package Thread.ThreadPoolManual;

public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[8];
        long startTime = System.currentTimeMillis();
        for(int i=1 ; i<9 ; i++) {
            int finalI = i;
            threads[i-1] = new Thread(()->{
                long ans = factorial(finalI);
                System.out.println(ans);
            });

            threads[i-1].start();
        }

        for(int i=1 ; i<9 ; i++) {
            try {
                threads[i-1].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
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

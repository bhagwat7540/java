import java.util.Scanner;

public class PlaceOfOlymipad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-- > 0) {
            long n = scanner.nextInt();
            long m = scanner.nextInt();
            long k = scanner.nextInt();

            long start = 1, end = m, ans=-1;
            while(start <= end) {
                long mid = start + (end-start)/2;

                long feasible = m/(mid+1)*mid + m%(mid+1);
                long totalFeasible = feasible * n;

                if(totalFeasible >= k) {
                    ans = mid;
                    end = mid-1;
                }
                else start = mid+1;
            }

            System.out.println(ans);
        }
    }
}

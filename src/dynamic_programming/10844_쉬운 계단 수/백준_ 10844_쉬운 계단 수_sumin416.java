import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main {
    static long[][] d;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
               new Main().solve();
        }
        
        public void solve() {
            Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
            long[][] dp = new long[101][11];

            for (int i = 1; i <= 9; i++) {
                   dp[1][i] = 1;
            }
 
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][1];
                for (int j = 1; j <= 9; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000 ;
                }
            }
 
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[n][i];
            }
            System.out.println(sum % 1000000000);
        }
 
}

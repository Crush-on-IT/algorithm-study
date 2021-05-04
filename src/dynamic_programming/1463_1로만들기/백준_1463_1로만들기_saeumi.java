package Dynamic_programming;

import java.util.*;

public class 백준_1463_1로만들기_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] dp = new int[a + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= a; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[a]);

	}

}

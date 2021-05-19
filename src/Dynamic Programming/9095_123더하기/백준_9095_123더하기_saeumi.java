package Dynamic_programming;

import java.io.*;

public class 백준_9095_123더하기_saeumi { //규칙 찾는 문제 

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int i = 4; i <= 10; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}
			System.out.println(dp[n]);
		}
	}
}

package Dynamic_programming;

import java.io.*;

public class 백준_2579_계단오르기_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //계단의 수 
		int jump =0; 
		int walk=0;
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		 
		if(N>=2) {
			dp[2] = dp[1] + arr[2];
		}
		
		for(int i=3; i<=N; i++) {
			jump = arr[i] + dp[i-2];
			walk = arr[i-1] + arr[i] + dp[i-3];
			dp[i] = Math.max(jump, walk);
		}
		
		System.out.println(dp[N]);
	}

}

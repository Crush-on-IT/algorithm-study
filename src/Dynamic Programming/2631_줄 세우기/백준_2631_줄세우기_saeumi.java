package Dynamic_programming;

import java.io.*;
import java.util.*;

public class 백준_2631_줄세우기_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			dp[i] =1;
			for(int j =0; j<=i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j] ) {
					dp[i] = dp[j] +1;
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(N- dp[N-1]);
		
	}

}

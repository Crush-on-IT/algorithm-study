package Dynamic_programming;

import java.io.*;
import java.util.*;

public class 백준_1010_다리놓기_saeumi { //mCn

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N+1][M+1];
			
			for(int n=2; n<=N; n++) {
				arr[n][1] =0;
			}
			
			for(int m=1; m<=M; m++) {
				arr[1][m] =m;
			}
			
			for(int i=2; i<=N; i++) {
				for(int j =2; j<=M ; j++) {
					arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
				}
			}
			
			System.out.println(arr[N][M]);
		}
	}

}

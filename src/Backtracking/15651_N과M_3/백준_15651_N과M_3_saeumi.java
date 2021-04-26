package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15651_N과M_3_saeumi { // 중복순열

	private static int N, M;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int count) {

		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			numbers[count] = i;
			perm(count +1);
			
		}
		
		
	}

}

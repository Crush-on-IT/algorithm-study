package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15657_N과M_8_saeumi { // 중복 조합
	
	private static int[] arr, numbers;
	private static StringBuilder sb = new StringBuilder();
	private static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		numbers = new int[M];

		Arrays.sort(arr);
		comb(0, 1);
		System.out.println(sb);

	}

	private static void comb(int count, int start) {

		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[count] = arr[i];
			comb(count + 1, i);
		}
	}

}

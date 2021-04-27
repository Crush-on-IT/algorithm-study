package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15655_N과M_6_saeumi {

	private static int N, M;
	private static int[] arr;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException { // 조합

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		numbers = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

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
			comb(count + 1, i + 1);
		}

	}

}

package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15650_N과M_2_saeumi {// 조합

	private static int N, M;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];

		comb(0,1);
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

		for (int i = start; i <=  N; i++) {
			numbers[count] = i;
			comb(count + 1, i + 1);
		}

	}

}

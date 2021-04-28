package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15664_N과M_10_saeumi {//조합인데 중복된 수 거르기 문제 
	private static int[] numbers, arr;
	private static int N, M;
	private static StringBuilder sb;
	private static LinkedHashSet<String> answer;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		numbers = new int[M];
		answer = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		comb(0, 1);
		answer.forEach(System.out::println);

	} // end of main

	private static void comb(int count, int start) {

		if (count == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			answer.add(sb.toString());
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[count] = arr[i];
			comb(count + 1, i + 1);
		}
	}
} // end of class

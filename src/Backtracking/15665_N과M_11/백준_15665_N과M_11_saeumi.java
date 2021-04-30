package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15665_N과M_11_saeumi { // 중복순열, 겹치는 거 없이 !

	private static int N;
	private static int[] arr;
	private static int[] number;
	private static int M;
	private static StringBuilder sb;
	private static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = new LinkedHashSet<>();
		arr = new int[N + 1];
		number = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		perm(0);
		answer.forEach(System.out::println);
	}

	private static void perm(int count) {

		if (count == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(number[i]).append(" ");
			}
			answer.add(sb.toString());
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			number[count] = arr[i];
			perm(count + 1);
		}
	}

}

package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15663_N과M_9_saeumi {

	private static int[] arr, numbers;
	private static StringBuilder sb;
	private static int N, M;
	private static boolean[] isChecked;
	private static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		numbers = new int[M];
		isChecked = new boolean[N];
		answer = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		perm(0);
		answer.forEach(System.out::println);
	}

	private static void perm(int count) {

		if (count == M) {
			sb = new StringBuilder();
			for (int p : numbers)
				sb.append(p).append(' ');
			answer.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isChecked[i])
				continue;
			isChecked[i] = true;
			numbers[count] = arr[i];
			perm(count + 1);
			isChecked[i] = false;

		}
	}
}

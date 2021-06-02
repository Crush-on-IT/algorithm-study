package Greedy;

import java.io.*;
import java.util.*;

public class 백준_20300_서강근육맨_saeumi {

	private static int N;
	private static long answer;
	private static long[] weight;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 기구 개수
		weight = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(weight);

		if (N % 2 != 0) {
			answer = weight[N - 1];
			for (int i = 0; i < (N - 1) / 2; i++) {
				answer = Math.max(answer, weight[i] + weight[N - 2 - i]);
			}

		} else {
			answer = weight[0] + weight[N - 1];
			for (int i = 0; i < N / 2; i++) {
				answer = Math.max(answer, weight[i] + weight[N - 1 - i]);
			}
		}
		System.out.println(answer);

	} // end of main

} // end of class

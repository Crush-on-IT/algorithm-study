package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_1182_부분수열의합_saeumi { // 부분집합!

	private static int[] arr;
	private static int N, S;
	private static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Subset(0, 0, 0);
		System.out.println(answer);
	} // end of main

	private static void Subset(int index, int sum, int count) {
		if (index == N) {
			if (count != 0 && sum == S) {
				answer++;
			}
			return;
		}

		Subset(index + 1, sum + arr[index], count + 1); // 인덱스 더하기 (선택o)
		Subset(index + 1, sum, count); //인덱스 더하지 않기 (선택x)
	}
} // end of class

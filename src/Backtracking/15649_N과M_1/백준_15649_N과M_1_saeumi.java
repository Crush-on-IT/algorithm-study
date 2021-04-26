package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15649_N과M_1_saeumi {

	private static int N, M;
	private static int[] numbers;
	private static boolean[] isSelected;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M]; // 1부터 시작이니까
		isSelected = new boolean[N + 1];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int count) {

		// dfs탈출 == > 뽑은 개수가 M개와 동일하다면
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		// 뽑지 않은 것 -> dfs 재귀 호출
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			numbers[count] = i; // 뽑기
			dfs(count + 1); // 그 다음 값 뽑기 위해서 재귀호출
			isSelected[i] = false; // 뽑은 뒤 미방문 처리
		}
	}
}

package Divide_Conquer;

import java.io.*;
import java.util.*;

public class 백준_1992_쿼드트리_saeumi {

	private static int N;
	private static int[][] map;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = (str.charAt(j)) - '0';
			}
		}
		dfs(0, 0, N);
		System.out.println(sb);
	} // end of main

	private static void dfs(int x, int y, int N) {

		int count = 0;
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}

		if (count == N * N) sb.append("1");
		else if (count == 0) sb.append("0");
		else {
			sb.append("(");
			dfs(x, y, N / 2);
			dfs(x, y + N / 2, N / 2);
			dfs(x + N / 2, y, N / 2);
			dfs(x + N / 2, y + N / 2, N / 2);
			sb.append(")");
		}
	}
} // end of class

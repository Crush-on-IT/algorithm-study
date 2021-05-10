package Divide_Conquer;

import java.io.*;
import java.util.*;

public class 백준_2630_색종이만들기_saeumi {

	private static int N;
	private static int[][] map;
	private static int whiteZero, blueOne;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(N, 0, 0);
		System.out.println(whiteZero);
		System.out.println(blueOne);
	}

	private static void dfs(int N, int x, int y) {

		int count = 0;
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}

		if (count == 0) whiteZero++;
		else if (count == N * N) blueOne++;
		else {
			dfs(N / 2, x, y);
			dfs(N / 2, x + N / 2, y);
			dfs(N / 2, x, y + N / 2);
			dfs(N / 2, x + N / 2, y + N / 2);
		}
	}

}

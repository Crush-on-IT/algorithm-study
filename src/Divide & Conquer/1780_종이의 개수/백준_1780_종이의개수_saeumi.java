package Divide_Conquer;

 
import java.io.*;
import java.util.*;

public class 백준_1780_종이의개수_saeumi {

	private static int minusOne, zero, plusOne;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
	}

	private static void dfs(int x, int y, int N) {

		int minus = 0;
		int plus = 0;
		int zeroCount = 0;
		for (int i = x; i < N + x; i++) {
			for (int j = y; j < y + N; j++) {
				if (map[i][j] == 1) {
					plus++;
				} else if (map[i][j] == 0) {
					zeroCount++;
				} else if (map[i][j] == -1) {
					minus++;
				}
			}
		}

		if (plus == N * N)
			plusOne++;
		else if (minus == N * N)
			minusOne++;
		else if (zeroCount == N * N)
			zero++;

		else {
			dfs(x, y, N / 3); // 왼쪽 위
			dfs(x, y + N / 3, N / 3); // 중앙 위
			dfs(x, y + 2 * N / 3, N / 3); // 오른쪽 위

			dfs(x + N / 3, y, N / 3); // 왼쪽 중간
			dfs(x + N / 3, y + N / 3, N / 3); // 중앙 중간
			dfs(x + N / 3, y + 2 * N / 3, N / 3); // 오른쪽 중간

			dfs(x + 2 * N / 3, y, N / 3); // 왼쪽 아래
			dfs(x + 2 * N / 3, y + N / 3, N / 3); // 중앙 아래
			dfs(x + 2 * N / 3, y + 2 * N / 3, N / 3);
		}
	}
}

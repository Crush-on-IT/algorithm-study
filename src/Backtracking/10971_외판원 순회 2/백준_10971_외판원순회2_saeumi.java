package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_10971_외판원순회2_saeumi {
	static int N, min = Integer.MAX_VALUE, temp = 0;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처리
		for (int i = 0; i < N; i++) {
			// 다시 돌아올 위치 설정
			temp = i;
			dfs(i, i, 0, 0);
		}
		System.out.println(min);
	}

	private static void dfs(int row, int col, int cnt, int sum) {
		// N번 돌고, 다시 원위치로 탐색왔다면
		if (cnt == N && temp == col) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i] && map[col][i] != 0 && sum + map[col][i] < min) {
				// 방문 체크
				visit[i] = true;
				dfs(col, i, cnt + 1, sum + map[col][i]);
				// 방문 언체크
				visit[i] = false;
			}
		}
	}
}
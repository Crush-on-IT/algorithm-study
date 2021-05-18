package Shortest_Path;

import java.io.*;
import java.util.*;

public class 백준_11265_끝나지않는파티_saeumi {

	private static int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 파티장의 크기
		int M = Integer.parseInt(st.nextToken()); // 손님의 수
		int map[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = INF;
				if (i == j) {
					map[i][j] = 0;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[j][k]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (map[a][b] <= c) {
				sb.append("Enjoy other party").append("\n");
			} else {
				sb.append("Stay here").append("\n");
			}
		}
		System.out.println(sb);
	}
}
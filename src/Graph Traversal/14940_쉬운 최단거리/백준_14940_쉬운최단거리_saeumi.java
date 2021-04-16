package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_14940_쉬운최단거리 {

	static class shortdistance {
		public shortdistance(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<shortdistance> queue = new LinkedList<shortdistance>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로 크기
		m = Integer.parseInt(st.nextToken()); // 가로 크기

		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					queue.offer(new shortdistance(i, j));
					visit[i][j] = true;
				} else if (map[i][j] == 0) {
					visit[i][j] = true;
				}
			}
		}
		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					sb.append(-1).append(" ");
				} else {
					sb.append(map[i][j] + " ");
				}
			}
			sb.append("\n");

		}
		System.out.println(sb);
		System.exit(0);
	} // end of main

	private static void bfs() {

		while (!queue.isEmpty()) {
			shortdistance sh = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = sh.x + dx[k];
				int ny = sh.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
					queue.offer(new shortdistance(nx, ny));
					visit[nx][ny] = true;
					map[nx][ny] = map[sh.x][sh.y] + 1;
				}
			}

		}
	}
} // end of class

package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_16973_직사각형탈출_saeumi {

	static class escape {
		int x;
		int y;
		int depth;

		public escape(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static int N, M ,answer = Integer.MAX_VALUE;
	static int H, W, startRow, startCol, endRow, endCol;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N격자 세로
		M = Integer.parseInt(st.nextToken()); // M격자 가로
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		startRow = Integer.parseInt(st.nextToken());
		startCol = Integer.parseInt(st.nextToken());
		endRow = Integer.parseInt(st.nextToken());
		endCol = Integer.parseInt(st.nextToken());

		bfs(startRow, startCol);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void bfs(int x, int y) {

		Queue<escape> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.offer(new escape(startRow, startCol, 0));

		while (!queue.isEmpty()) {
			escape esc = queue.poll();
			if (esc.x == endRow && esc.y == endCol) {
				if (answer > esc.depth) {
					answer = esc.depth;
				}
			}

			for (int k = 0; k < 4; k++) {
				int nx = esc.x + dx[k];
				int ny = esc.y + dy[k];

				if (nx < 1 || ny < 1 || nx > N || ny > M || visit[nx][ny] == true)
					continue;
				if (!checkSquare(nx, ny))
					continue;
				visit[nx][ny] = true;
				queue.offer(new escape(nx, ny, esc.depth + 1));
			}
		}
	}

	private static boolean checkSquare(int x, int y) {
		for (int i = x; i < x + H; i++) {
			for (int j = y; j < y + W; j++) {
				if (i < 1 || j < 1 || i > N || j > M || map[i][j] == 1)
					return false;
			}
		}
		return true;
	}
} // end of class

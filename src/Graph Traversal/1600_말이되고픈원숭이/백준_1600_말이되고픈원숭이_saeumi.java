package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_1600_말이되고픈원숭이 {

	static class Position {
		int x, y, k, move;

		public Position(int x, int y, int k, int move) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.move = move;
		}
	}

	static int K, W, H;
	static int[][] arr;
	static boolean[][][] visit;
	static Queue<Position> queue = new LinkedList<Position>();

	static int[] dx = { 1, -1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 원숭이가 말처럼 움직일 수 있는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 열
		H = Integer.parseInt(st.nextToken()); // 행

		arr = new int[H][W];
		visit = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue.offer(new Position(0, 0, K, 0));
		visit[0][0][K] = true;

		if (H == 1 && W == 1) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Position po = queue.poll();

			for (int k = 0; k < 12; k++) {
				if (po.k == 0 && k >= 4) // 말처럼 뛰는 횟수가 0 && k >= 4 (말처럼 뛰는 상황)
					break;

				int nx = po.x + dx[k];
				int ny = po.y + dy[k];
				int nk = k >= 4 ? po.k - 1 : po.k; // k >= 4 -> 말처럼 뛰는 상황 이면 1개씩 카운트 줄여야하니까 !
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || visit[nx][ny][nk] || arr[nx][ny] == 1)
					continue;
				if (nx == H - 1 && ny == W - 1) {
					System.out.println(po.move + 1);
					return;

				}
				queue.offer(new Position(nx, ny, nk, po.move + 1));
				visit[nx][ny][nk] = true;
			}
		}
		 System.out.println(-1); //시작점에서 도착점까지 갈 수 없는 경우 -1

	} // end of main

} // end of class

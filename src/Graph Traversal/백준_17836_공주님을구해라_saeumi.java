package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_17836_공주님을구해라_saeumi { // 말이 되고픈 원숭이처럼 ! 접근!!

	static class princess {
		public princess(int x, int y, int knife, int time) {
			super();
			this.x = x;
			this.y = y;
			this.knife = knife;
			this.time = time;
		}

		int x;
		int y;
		int knife;
		int time;
	}

	static int N, M, T;
	static int[][] arr;
	static boolean[][][] visit;
	static int result=0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<princess> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][2]; //검은 반드시 한 개 존재한다. 

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		if (result == 0) {
			System.out.println("Fail");
		} else {
			System.out.println(result);
		}
	}

	private static void bfs() {

		Queue<princess> queue = new LinkedList<>();
		queue.offer(new princess(0, 0, 0, 0));
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {

			princess prin = queue.poll();

			if (prin.x == N - 1 && prin.y == M - 1) {
				if (prin.time <= T)
					result = prin.time;
				break;
			}

			if (prin.time > T)
				break;

			for (int k = 0; k < 4; k++) {

				int nx = prin.x + dx[k];
				int ny = prin.y + dy[k];
				int nknife = prin.knife;
				int nd = prin.time + 1;

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][nknife])
					continue;
				if (nknife == 0) {
					if (arr[nx][ny] == 0) {
						visit[nx][ny][0] = true;
						queue.offer(new princess(nx, ny, 0, nd));
					} else if (arr[nx][ny] == 2) {
						visit[nx][ny][1] = true;
						queue.offer(new princess(nx, ny, 1, nd));
					}
				} else {
					if (arr[nx][ny] == 1 || arr[nx][ny] == 0) {
						visit[nx][ny][1] = true;
						queue.offer(new princess(nx, ny, 1, nd));
					}
				}
			}
		}
	}
}

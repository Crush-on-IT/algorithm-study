package BFS_DFS_Review;

import java.io.*;
import java.util.*;

class zone {
	int x;
	int y;

	public zone(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class 백준_14502_연구소_saeumi {

	static int N, M;
	static int[][] arr;
	static int max = 0;
	static int count = 0;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	private static int[][] virusmap;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs로 벽 세우고 bfs로 탐방하기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(1);
					arr[i][j] = 0; // 다시 바꿔주기
				}
			}
		}
		System.out.println(max);
	}

	private static void dfs(int count) {
		if (count == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(count + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		virusmap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusmap[i][j] = arr[i][j]; // 배열 복사
			}
		}

		Queue<zone> queue = new LinkedList<zone>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusmap[i][j] == 2) {
					queue.offer(new zone(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			zone zone = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = zone.x + dx[k];
				int ny = zone.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && virusmap[nx][ny] == 0) {
					virusmap[nx][ny] = 2;
					queue.offer(new zone(nx, ny));
				}
			}
		}

		max = virusCount();
	}

	private static int virusCount() {

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusmap[i][j] == 0) {
					count++;
				}
			}
		}
		return Math.max(max, count);
	}
}

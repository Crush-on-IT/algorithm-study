package BFS_DFS_Review;

import java.io.*;
import java.util.*;

class Tomato {
	int x;
	int y;
	int depth;

	public Tomato(int x, int y, int depth) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

}

public class 백준_7576_토마토_saeumi { // 1: 익은 토마토, 0: 익지 않은 토마토 , -1 : 토마토 없는 칸

	private static int col, row;
	private static int[][] arr;
	private static boolean[][] visit;
	private static int count = 0; // 토마토 카운트 해줄 변수
	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };
	private static Queue<Tomato> queue = new LinkedList<Tomato>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		visit = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					queue.offer(new Tomato(i,j, 0));
					visit[i][j] = true;
					bfs(i, j);
				}

			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(count);

	} // end of main

	private static void bfs(int x, int y) {

		while (!queue.isEmpty()) {
			Tomato toma = queue.poll();
			count = Math.max(count, toma.depth);

			for (int k = 0; k < 4; k++) {
				int nx = toma.x + dx[k];
				int ny = toma.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && arr[nx][ny] == 1) {
					queue.offer(new Tomato(nx, ny, toma.depth + 1));
					visit[nx][ny] = true;
					arr[nx][ny] = 1; // 로 바꿔주기 !
				}
			}
		}
	}

} // end of class

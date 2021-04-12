package BFS_DFS_Review;

import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;

	public Point(int x, int y)  {
		super();
		this.x = x;
		this.y = y;
	}

}

public class 백준_2178_미로탐색_saeumi {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	private static boolean[][] visit;
	private static int N;
	private static int M;
	private static int cnt;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(arr[N-1][M-1]);
	}

	private static void bfs(int x, int y ) {

		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y ));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Point po = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = po.x + dx[k];
				int ny = po.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && arr[nx][ny] == 1) {
					queue.offer(new Point(nx, ny ));
					arr[nx][ny] = arr[po.x][po.y] +1;
					visit[nx][ny] = true;
				}
			}

		}

	}

}

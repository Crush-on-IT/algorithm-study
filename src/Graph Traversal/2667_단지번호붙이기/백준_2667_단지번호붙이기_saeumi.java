package BFS_DFS_Review;

import java.io.*;
import java.util.*;

class Danji {
	int x;
	int y;

	public Danji(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class 백준_2667_단지번호붙이기_saeumi {

	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };
	private static int N;
	private static int[][] arr;
	private static boolean[][] visit;
	static ArrayList<Integer> list  = new ArrayList<>();
	static int totalHouse =0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		 list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(totalHouse);
		Collections.sort(list);
		for (int num : list) {
			System.out.println(num);
		}
	}

	private static void bfs(int x, int y) {

		Queue<Danji> queue = new LinkedList<Danji>();
		int danji =0;
		queue.offer(new Danji(x, y));
		visit[x][y] = true;
		totalHouse++;
		danji++;

		while (!queue.isEmpty()) {
			Danji dan = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = dan.x + dx[k];
				int ny = dan.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && arr[nx][ny] == 1) {
					queue.offer(new Danji(nx, ny));
					visit[nx][ny] = true;
					danji ++;
				}

			}
		}
		list.add(danji);
	}
}

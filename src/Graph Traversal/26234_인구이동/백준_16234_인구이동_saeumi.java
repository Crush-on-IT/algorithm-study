package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_16234_인구이동 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, L, R, map[][];
	static boolean visited[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static Queue<Point> q;
	static List<Point> group;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		group = new LinkedList<>();
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(process());
	}

	private static int process() {

		int cnt = 0; // 인구 이동 발생 수
		boolean isMove = false;
		
		while (true) {

			visited = new boolean[N][N];
			isMove = false;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 이미 확인한 나라 pass
					if (visited[r][c])
						continue;
					// 연합국을 확인해보자.
					if (open(r, c))
						isMove = true;
				}
			}
			// 연합국이 존재한다면 인구 이동 발생
			if (isMove)
				cnt++;
			else
				return cnt;
		}
	}

	private static boolean open(int r, int c) {

		q.clear();
		group.clear();

		q.add(new Point(r, c));
		group.add(new Point(r, c));
		visited[r][c] = true;

		int sum = map[r][c];
		// 연합국을 찾으러
		while (!q.isEmpty()) {

			Point now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				// 범위를 초과하거나 이미 방문한 국가 pass
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;
				// 두 나라의 인구 차이가 L명 이상, R명 이하가 아니라면 pass
				int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);
				if (diff < L || diff > R)
					continue;

				// 연합의 인구수와 국가 정보 저장
				sum += map[nr][nc];
				q.add(new Point(nr, nc));
				group.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}

		}

		// 연합국이 존재하지 않다면
		if (group.size() == 1)
			return false;
		else {
			// 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
			int tmp = sum / group.size();
			for (Point p : group) {
				map[p.r][p.c] = tmp;
			}

			return true;
		}
	}

}
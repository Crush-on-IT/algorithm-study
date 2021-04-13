package BFS_DFS_Review;

import java.io.*;
import java.util.*;

class Toma {
	int x;
	int y;
	int z;
	int day;

	public Toma(int x, int y, int z, int day) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}

}

public class 백준_7569_토마토_saeumi {

	static int dx[] = {1, 0, -1, 0, 0, 0};
	static int dy[] =  {0, 1, 0, -1, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	static int M, N, H;
	static boolean visit[][][];
	static int map[][][];
	static int count = 0;
	static Queue<Toma> queue = new LinkedList<Toma>();

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		map = new int[H+1][N+1][M+1] ;
		visit = new boolean[H+1][N+1][M+1];

		for (int h =1; h <= H; h++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					map[h][r][c] = sc.nextInt();
				}
			}
		}
		
		for (int h =1; h <= H; h++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (  map[h][r][c] == 1) {
						queue.offer(new Toma(r,c,h,0));
						visit[h][r][c] = true;
					}
				}
			}
		}
		bfs();

		for (int h =1; h <= H; h++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (map[h][r][c] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs() {

	
		while (!queue.isEmpty()) {
			Toma to = queue.poll();
			count = Math.max(count, to.day);

			for (int k = 0; k < 6; k++) {
				int nx = to.x + dx[k];
				int ny = to.y + dy[k];
				int nh = to.z + dz[k];

				if (nx > 0 && ny > 0 && nh > 0 && nx <= N && ny <= M && nh <= H && !visit[nh][nx][ny]
						&& map[nh][nx][ny] == 0) {
					queue.offer(new Toma(  nx, ny,nh, to.day + 1));
					visit[nh][nx][ny] = true;
					map[nh][nx][ny] = 1;
				}
			}
		}
	}
}

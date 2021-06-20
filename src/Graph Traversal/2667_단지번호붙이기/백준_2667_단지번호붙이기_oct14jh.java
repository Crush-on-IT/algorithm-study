import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {
	static class Point {
		int r;
		int c;
		public Point() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> resultCount = new ArrayList<>();
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
//			StringTokenizer st = new StringTokenizer(br.readLine().trim(), "");
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
//				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					result++;
					resultCount.add(bfs(i,j));
				}
			}
		}
		
//		resultCount.sort(null);
		Collections.sort(resultCount);
		System.out.println(result);
		for(int i : resultCount) {
			System.out.println(i);
		}
	}
	
	private static int bfs(int r, int c) {
		int count = 1;
		Point current = new Point(r,c);
		Queue<Point> q = new LinkedList<>();
		q.offer(current);
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			int nr = 0, nc = 0;
			for(int m = 0; m < 4; m++) {
				nr = current.r + dr[m];
				nc = current.c + dc[m];
				if(isLineOut(nr, nc) || visited[nr][nc])
					continue;
				q.offer(new Point(nr, nc));
				visited[nr][nc] = true;
				count++;
			}
		}
		return count;
	}
	
	private static boolean isLineOut(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N || map[r][c] == 0) {
			return true;
		}
		return false;
	}
}

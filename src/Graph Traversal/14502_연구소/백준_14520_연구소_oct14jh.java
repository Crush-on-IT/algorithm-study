import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Point {
		int row;
		int col;
		public Point() {super();}
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	private static int N, M;
	private static int[][] map;
	private static List<Point> initBlock = new ArrayList<>();
	private static List<Point> initVirus = new ArrayList<>();
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) { 
					initVirus.add(new Point(i, j));
				}
			}
		}
		
		block3Combination(0, 0, 0);
	
		System.out.println(result);
		br.close();
	}

	private static void block3Combination(int row, int col, int count) {	
		if(count == 3) {
			virusingBFS(); 
			return;
		}
		
		for(int i = row; i < N; i++) {
			for(int j = col; j < M; j++) {
				if(map[i][j] != 0)
					continue;
				map[i][j] = 1;
				block3Combination(i, j + 1, count + 1);
				map[i][j] = 0;
			}
			col = 0;
		}
	}
	
	private static void virusingBFS() {
		int safety = 0;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		int[][] copy = new int[N][M];
        
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	
		for(Point temp : initVirus) {
			q.offer(temp);
			visited[temp.row][temp.col] = true;
		}
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int m = 0; m < 4; m++) {
				int nr = current.row + dr[m];
				int nc = current.col + dc[m];
				
				if(isLineOut(nr,nc) || visited[nr][nc])
					continue;
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					q.offer(new Point(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copy[i][j] == 0)
					safety++;
			}
		}
		
		if(result < safety) {
			result = safety;
		}
	}
	
	private static boolean isLineOut(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M)
			return true;
		return false;
	}
}

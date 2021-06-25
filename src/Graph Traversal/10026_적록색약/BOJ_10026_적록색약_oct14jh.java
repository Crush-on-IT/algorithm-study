package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_10026_적록색약_G5 {
	private static class Point {
		int row;
		int col;
		
		public Point() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	private static int N;
	private static int[] result = new int[2];
	
	/* 데이터 들어가는 배열과 방문처리 위한 배열 */
	private static char[][] map;
	private static boolean[][] visitedNoRGB;	// 적록색약 아닌 사람
	private static boolean[][] visitedYesRGB;	// 적록색약 인 사람
	
	/* 4방 탐색 위한 배열 */
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	/* 메인 함수 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new char[N][N];
		visitedNoRGB = new boolean[N][N];
		visitedYesRGB = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String strLine = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = strLine.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 적록색약 아닌 사람
				if(!visitedNoRGB[i][j]) {
						bfsNoRGB(i, j);
						result[0]++;
				}
				// 적록색약 인 사람
				if(!visitedYesRGB[i][j]) {
						bfsYesRGB(i, j);
						result[1]++;
				}
			}
		}
		
		for(int i=0; i<2; i++) {
			System.out.print(result[i] + " ");
		}
		
		br.close();
	}

	/* 적록색약 아닌 경우의 bfs */
	private static void bfsNoRGB(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		Point current = new Point(r,c);
		char currentColor = map[r][c];
		
		q.offer(current);
		visitedNoRGB[r][c] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			int nr = 0, nc = 0;
			for(int direction = 0; direction < 4; direction++) {
				nr = current.row + dr[direction];
				nc = current.col + dc[direction];
				
				if(isLineOut(nr, nc) || visitedNoRGB[nr][nc] || map[nr][nc] != currentColor)
					continue;
				q.offer(new Point(nr, nc));
				visitedNoRGB[nr][nc] = true;
			}
		}
	}
	
	/* 적록색약 인 경우의 bfs*/
	private static void bfsYesRGB(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		Point current = new Point(r,c);
		char currentColor = map[r][c];

		q.offer(current);
		visitedYesRGB[r][c] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			int nr = 0, nc = 0;
			for(int direction = 0; direction < 4; direction++) {
				nr = current.row + dr[direction];
				nc = current.col + dc[direction];
				
				if(isLineOut(nr, nc) || visitedYesRGB[nr][nc])
					continue;
				
				if(map[nr][nc] != currentColor) {
					if(map[nr][nc] == 'B' || currentColor == 'B')
					continue;
				}
				q.offer(new Point(nr, nc));
				visitedYesRGB[nr][nc] = true;
			}
		}
	}

	/* 배열 벗어나는지 체크해주는 메소드 */
	private static boolean isLineOut(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N)
			return true;
		return false;
	}
}
package sumin.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ17070_파이프옮기기1 {

	static class Pipe{
		int r;
		int c;
		int dir;
		public Pipe(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int[][] D = {{0,2},{1,2},{0,1,2}}; 
	static int[][] dxdy = {{0,1},{1,0},{1,1}};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		String[] input = new String[N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		Queue<Pipe> queue = new LinkedList<>();
		Pipe pipe = new Pipe(0,1,0);
		queue.offer(pipe);
		
		int answer = 0;
		int curDir = 0;
		int nr=0,nc=0;
		
		loop1:
		while(!queue.isEmpty()) {
			Pipe cur = queue.poll();
			
			if(cur.r == N-1 && cur.c == N-1) {
				++answer;
				continue loop1;
			}
			curDir = cur.dir;
			//cur이 이동할 수 있는 곳이 있다면 queue에 넣기
			loop:
			for (int i = 0; i < D[curDir].length; i++) {
				switch(D[curDir][i]) {
					case 0:
					case 1:
						nr = cur.r+dxdy[D[curDir][i]][0];
						nc = cur.c+dxdy[D[curDir][i]][1];
						if(nr>=N || nc>=N)	continue loop;
						if(map[nr][nc]==0)	queue.offer(new Pipe(nr,nc,D[curDir][i]));
						break;
					case 2:
						for (int j = 0; j < 3; j++) {
							nr = cur.r + dxdy[j][0];
							nc = cur.c + dxdy[j][1];
							if( nr>=N || nc>=N || map[nr][nc]==1 )	continue loop;
						}
						queue.offer(new Pipe(nr,nc,D[curDir][i]));
						break;
				}
			}
			
		}
		
		System.out.println(answer);
	}

}


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	//초기 1인 좌표 큐에 넣기
	//사방탐색 해서 0->1로 바꾸고  큐에 넣기 bfs
	//몇레벨인지 체크
	//완료 후 0인거 하나라도 있으면 -1
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int[][] map = new int[N][M];
		Queue<Point> queue = new LinkedList<Point>();
		for(int i = 0 ; i < N ; ++i) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; ++j) {
				map[i][j]=Integer.parseInt(st1.nextToken());
				if(map[i][j]==1)	queue.offer(new Point(i,j));	
			}
		}
		
		
		int result=-1;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			while(size>0) {
				Point point = queue.poll();
				for(int i = 0 ; i < dx.length ; ++i) {
					int X = point.x+dx[i];
					int Y = point.y+dy[i];
					if(check(X,Y)
							&&map[X][Y]==0) {
						map[X][Y]=1;
						queue.offer(new Point(X,Y));
					}
				}
				--size;
			}
			
			++result;
			
			
		}
			
		for(int i = 0 ; i < N ; ++i)
		{
			for(int j = 0 ; j < M ; ++j) {
				if(map[i][j]==0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean check(int x, int y) {
		if(x<0||x>=N||y<0||y>=M)	return false;
		return true;
	}
}


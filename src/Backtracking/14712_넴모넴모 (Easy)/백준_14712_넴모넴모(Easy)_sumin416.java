import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N,M,answer=0;
	static int[][] dxdy = {{-1,-1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[N][M];
		nemo(visited,0,0);
		System.out.println(answer);
	}
	private static void nemo(boolean[][] visited, int x, int y) {
		if(x == N) {
			++answer;
			return;
		}
		
		int nx=x,ny=y;
		++ny;
		if(ny==M) {
			++nx;
			ny=0;
		}
		
		nemo(visited,nx,ny);
		
		int tX,tY,cnt=0;
		//넴모들어갈수 있는 자리인지 체크
		for (int i = 0; i < dxdy.length; i++) {
			tX = x+dxdy[i][0];
			tY = y+dxdy[i][1];
			
			if(tX<0 || tY<0)	continue;
			if(visited[tX][tY])	++cnt;
		}
		if(cnt!=3) {
			visited[x][y] = true;
			nemo(visited,nx,ny);
			visited[x][y] = false;
		}
	}
	
}

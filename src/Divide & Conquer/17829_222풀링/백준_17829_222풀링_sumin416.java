import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static final int INF = Integer.MIN_VALUE;
	static int[][] dxdy = {{0,0},{0,1},{1,0},{1,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int nx,ny;
		int max1,max2,cur;
		
		while(N>=2) {
			
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					//i,j에서 dxdy
					max1 = INF;
					max2 = INF;
					for (int j2 = 0; j2 < dxdy.length; j2++) {
						nx = i*2+dxdy[j2][0];
						ny = j*2+dxdy[j2][1];
						
						cur = map[nx][ny];
						
						if(max1 <= cur ) {
							max2 = max1;
							max1 = cur;
						}
						else if(max2 < cur){
							max2 = cur;
						}
					}
//					System.out.print(i+" "+j+" : ");
//					System.out.println(max2);
					map[i][j] = max2;
				}
			}
			
			
			N/=2;
		}
		
		System.out.println(map[0][0]);
	}
}

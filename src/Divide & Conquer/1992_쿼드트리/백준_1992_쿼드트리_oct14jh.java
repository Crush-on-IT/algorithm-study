import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리_oct14jh {
	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Object obj = new Object();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			String temp = br.readLine().trim();
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(temp.substring(j, j+1));
			}
		}
		divideConquer(0,0,N);
	}

// 2*2 단위로 분할하는 작업
	private static void divideConquer(int r, int c, int n) {
		if(check(r,c,n)) {
			System.out.print(M);
		}
		else {
			System.out.print("(");
			int s = n/2;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++){
					divideConquer(r+s*i, c+s*j, s);
				}
			}
			System.out.print(")");
		}
	}

// 배열안에 배열이 가지고 있는 요소가 같은지 체크
	private static boolean check(int r, int c, int n) {
		int std = map[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(std != map[i][j])
					return false;
			}
		}
		M = std;
		return true;
	}
}
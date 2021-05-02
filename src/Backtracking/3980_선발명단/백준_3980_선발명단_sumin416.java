import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N=11,M,answer=0;
	static int[][] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		M = Integer.parseInt(br.readLine());
		for (int t = 0; t < M; t++) {
			answer = 0;
			input = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			} 
			
			boolean[] checked = new boolean[N]; 
			pose(checked,0,0);
			
			System.out.println(answer);
		}
	}

	private static void pose(boolean[] checked, int cnt, int sum) {
		if(cnt == N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(input[cnt][i] == 0 || checked[i])	continue;
			
			checked[i] = true;
			pose(checked, cnt+1, sum+input[cnt][i]);
			checked[i] = false;
		}
	}


	

	
	
}

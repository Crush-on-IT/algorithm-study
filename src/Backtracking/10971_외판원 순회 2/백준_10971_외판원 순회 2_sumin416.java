import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,answer=Integer.MAX_VALUE;
	static int[][] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		} 

		boolean[] visited;
		//시작점
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			//System.out.print(i+" ");
			travel(visited, i,i, 1, 0);
		}
		
		System.out.println(answer);
	}

	private static void travel(boolean[] visited, int start,int initStart, int cnt, int sum) {
		if(cnt == N) {
			if(input[start][initStart] == 0)	return;
			sum += input[start][initStart];
			//System.out.println("sum:"+sum);
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(visited[i] || input[start][i]==0)	continue;
			//System.out.print(i+" ");
			visited[i] = true;
			travel(visited, i,initStart, cnt+1, sum+input[start][i]);
			visited[i] = false;
			
		}
	}

	
	
}

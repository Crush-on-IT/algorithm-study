import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15649_N과M_1_oct14jh {
	private static int N, M;
	private static int[] input, output;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		input = new int[N];
		visited = new boolean[N];
		output = new int[M];
		int number = 1;
		for(int i = 0; i < N; i++) {
			input[i] = number++;
		}
		
		permutation(0);
		
		br.close();
	}
	private static void permutation(int count) {
		if(count == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == true){
				continue;
			}
			
			output[count] = input[i];
			visited[i] = true;
			permutation(count + 1);
			visited[i] = false;
		}
		
	}
}

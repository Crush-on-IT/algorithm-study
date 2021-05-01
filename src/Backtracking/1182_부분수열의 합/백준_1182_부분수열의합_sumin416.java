import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,answer=0;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(input);
		int[] arr = new int[N]; 
		boolean[] visited = new boolean[N];
		make(arr,visited,0,0);
		System.out.println(answer);
	}
	private static void make(int[] arr, boolean[] visited, int cur, int cnt) {
		
		int sum = 0;
		//System.out.println(Arrays.toString(arr));
		for (int i = 0; i < cnt; i++) {
			sum += arr[i];
		}
		if(cnt!=0 && sum == M)	++answer;
		
		if(cnt==N) {
			return;
		}
		
		for (int i = cur; i < N; i++) {
			if(visited[i])	continue;
			
			visited[i] = true;
			arr[cnt] = input[i];
			make(arr,visited,i+1,cnt+1);
			visited[i] = false;
		}
	}
	
}

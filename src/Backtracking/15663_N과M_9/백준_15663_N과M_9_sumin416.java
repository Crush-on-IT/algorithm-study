import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new LinkedHashSet<String>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int[] arr = new int[M]; 
		boolean[] visited = new boolean[N];
		make(arr,visited,0,0);
		for(String s : set) {
			System.out.println(s);
		}
	}
	private static void make(int[] arr, boolean[] visited, int cur, int cnt) {
		if(cnt==M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			set.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i])	continue;
			
			visited[i] = true;
			arr[cnt] = input[i];
			make(arr,visited,i+1,cnt+1);
			visited[i] = false;
		}
	}
	
}

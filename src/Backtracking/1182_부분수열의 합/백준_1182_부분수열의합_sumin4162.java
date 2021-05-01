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
		make(0,0);
		if(M==0)	--answer;
		System.out.println(answer);
	}
	private static void make(int sum, int cnt) {
		//System.out.println(sum+" "+cnt);
		if(cnt==N) {
			if(sum == M)	++answer;
			return;
		}
		
		make(sum,cnt+1);
		make(sum+input[cnt],cnt+1);
	}
	
}

package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현_oct14jh {
	private static int N, M;
	private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cal == 0)
				union(a, b);
			else
				process(a, b);
		}
		
		br.close();
	}
	
	private static int findSet(int value) {
		if(value == parent[value])
			return value;
		return parent[value] = findSet(parent[value]);
	}
	
	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b)
			parent[b] = a;
	}
	
	private static void process(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a == b)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}	

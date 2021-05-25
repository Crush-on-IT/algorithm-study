package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	private static class Node implements Comparable<Node> {
		int start, end, value;
		
		public Node(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return o.value >= this.value ? -1 : 1;
		}
	}

	private static int V, E;
	private static int[] parent;
	private static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	private static int result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 최초 헤더는 자기자신으로
		parent = new int[V+1];
		for(int i = 0; i < V + 1; i++)
			parent[i] = i;
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int startTemp = Integer.parseInt(st.nextToken());
			int endTemp = Integer.parseInt(st.nextToken());
			int valueTemp = Integer.parseInt(st.nextToken());
			pq.add(new Node(startTemp, endTemp, valueTemp));
		}
		
		for(int i = 0; i < E; i++) {
			Node temp = pq.poll();
			
			int a = find(temp.start);
			int b = find(temp.end);
			
			if(a==b)
				continue;
			union(a, b);
			result += temp.value;
		}
		
		System.out.println(result);
		
	}

	private static int find(int v) {
		if(v == parent[v]) 
			return v;
		return parent[v];
	}
	
	private static void union(int a, int b) {
		int aHead = find(a);
		int bHead = find(b);
		
		if(aHead != bHead)
			parent[aHead] = b;
		else
			return;
	}
}

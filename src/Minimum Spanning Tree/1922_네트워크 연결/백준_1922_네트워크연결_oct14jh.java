import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결_oct14jh {
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
			return this.value - o.value;
		}
	}
	
	private static int N, M;
	private static int[] parent;
	private static Node[] data;
	private static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		data = new Node[M];
		
		parent = new int[N+1];
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tempStart = Integer.parseInt(st.nextToken());
			int tempEnd = Integer.parseInt(st.nextToken());
			int tempValue = Integer.parseInt(st.nextToken());
			data[i] = new Node(tempStart, tempEnd, tempValue);
		}
		
		result = kruskal();
		System.out.println(result);
	}
	
	private static int kruskal() {
		int tempResult = 0;
		int countEdge = N-1;
		Arrays.sort(data);
		
		for(int i = 0; i < M; i++) {
			if(countEdge == 0)
				break;
			
			int checkNode1 = find(data[i].start);
			int checkNode2 = find(data[i].end);
			
			if(checkNode1 == checkNode2) continue;
			
			union(checkNode1, checkNode2);
			tempResult += data[i].value;
			countEdge--;
		}
		return tempResult;
	}
	
	private static int find(int value) {
		if(value == parent[value])
			return value;
		return parent[value] = find(parent[value]);
	}
	
	private static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent != bParent)
			parent[aParent] = b;
		else
			return;
	}
}

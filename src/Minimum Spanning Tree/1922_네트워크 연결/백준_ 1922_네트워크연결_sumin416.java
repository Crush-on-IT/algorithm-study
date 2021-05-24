import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	
	static class Edge{
		int a;
		int b;
		int c;

		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static int[] parents;
	static List<Edge> list;

	public static void main(String[] args) throws Exception {
		long result = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a, b, c));

		}
		for (int i = 0; i <= N; i++)
			parents[i] = i;
		
		Collections.sort(list,new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c-o2.c;
			}
		});
		
		
		for (int i = 0; i < list.size(); i++) {
			Edge e = list.get(i);
			int start = e.a;
			int end = e.b;
			int res = find(start, end);
			
			if (res == 1) 
				continue;
			
			union(start, end);
			result += e.c;
		}

		System.out.println(result);

	}

	public static int parent(int idx) {
		if (parents[idx] == idx)
			return idx;
		return parents[idx] = parent(parents[idx]); // 매번 갱신해줌!
	}

	public static void union(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}

	public static int find(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a == b)
			return 1;
		else
			return 0;
	}

	

}

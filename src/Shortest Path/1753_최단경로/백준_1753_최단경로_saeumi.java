package Shortest_Path;

import java.io.*;
import java.util.*;

public class 백준_1753_최단경로_saeumi{

	private static int V, E, START, INF = Integer.MAX_VALUE;
	static ArrayList<Point> list[];
	static int dist[];

	static class Point implements Comparable<Point> {
		int vertex;
		int weight;

		public Point(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			if(this.weight > o.weight) {
				return 1;
			}
			return 0;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			dist[i] = INF;
		}

		START = Integer.parseInt(br.readLine());
		dist[START] = 0;

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			list[u].add(new Point(v, val));

		}
		
		solve();
		
		for(int i =1; i<=V; i++) {
			if(dist[i] == INF)
				System.out.println("INF");
			else 
				System.out.println(dist[i]);
		}

	}

	private static void solve() {
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(START, 0));
			
			while(!pq.isEmpty()) {
				Point po = pq.poll();
				
				if(dist[po.vertex] <po.weight) continue;
				for(int i=0; i<list[po.vertex].size(); i++) { //노드에 연결된 정점이 더 작은 값을 찾을 수 있도록 
					int tempIndex = list[po.vertex].get(i).vertex;
					int tempDist = po.weight + list[po.vertex].get(i).weight;
					
					if(dist[tempIndex] > tempDist) {
						dist[tempIndex] = tempDist;
						pq.add(new Point(tempIndex, tempDist));
					}
				}
			}
	}

}

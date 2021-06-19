package concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFS와BFS_S2 {
	private static int N, M, V;	// 정점 수, 간선 수, 시작정점
	private static List<Integer> a[];
	private static boolean[] visitedDFS;	// dfs 시, 방문했는지 체크하고자 쓰는 boolean형 배열
	private static boolean[] visitedBFS;	// bfs 시, 방문했는지 체크하고자 쓰는 boolean형 배열 (bfs는 재귀가 아니기에, 지역적으로 선언해도됨)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		visitedDFS = new boolean[N+1];	
		visitedBFS = new boolean[N+1];
		
		a = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			a[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			a[from].add(to);
			a[to].add(from);
		}
		for(int i = 1; i<N+1;i++) {
			a[i].sort(null);
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
		sc.close();
	}
	
	private static void dfs(int v) {
		visitedDFS[v] = true;
		System.out.print(v + " ");
		
		for(int current : a[v]) {
			if(!visitedDFS[current])
				dfs(current);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		int current = v;

		q.offer(current);
		visitedBFS[v] = true;
		
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.print(current + " ");
			
			for(int temp : a[current]) {
				if(!visitedBFS[temp]) {
					q.offer(temp);
					visitedBFS[temp] = true;
				}
			}
		}
	}
}
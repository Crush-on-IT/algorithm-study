package BFS_DFS_Review;

import java.io.*;
import java.util.*;

public class 백준_1260_DFS와BFS_saeumi {

	private static int N, M, V;
	private static int[][] arr;
	private static boolean[] visit;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 정점의 번호

		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = arr[to][from] = 1;
		}

		visit = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		visit = new boolean[N + 1];
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int point) {
		sb.append(point).append(" ");
		visit[point] = true;
		for (int i = 1; i <= N; i++) {
			if (arr[point][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int spoint) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(spoint);
		visit[spoint] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" "); //현재 포인트 poll해준거 sb에 넣기
			
			for (int i = 1; i <= N; i++) {
				if (arr[spoint][i] == 1 && !visit[i]) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}

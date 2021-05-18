package Shortest_Path;

import java.io.*;
import java.util.*;

public class 백준_18352_특정거리의도시찾기_saeumi {
	private static int A, B, N, M, K, X;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

		list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		 
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(X);
		int[] check = new int[N + 1];

		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 0; i < list[v].size(); i++) {
				if (check[list[v].get(i)] == 0) {
					check[list[v].get(i)] = check[v] + 1;
					queue.add(list[v].get(i));
				}
			}
		}
		
		
		boolean ok = false;
		for (int i = 1; i < check.length; i++) {
			if (check[i] == K && i != X) {
				ok = true;
				System.out.println(i);
			}
		}
		if (!ok)
			System.out.println(-1);
	}
}

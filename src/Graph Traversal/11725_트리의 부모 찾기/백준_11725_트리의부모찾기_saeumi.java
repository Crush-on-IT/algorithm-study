package BFS_DFS_Review;

import java.io.*;
import java.util.*;

public class 백준_11725_트리의부모찾기 {

	static int N;
	static ArrayList<Integer>[] tree;
	static boolean visit[];
	static int parent[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		} // 공간 할당 ArrayList에 들어갈 !

		for (int i = 1; i <= N - 1; i++) { //N-1개의 줄에 출력하니까 ! 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int x) {

		visit[x] = true;
		for (int i : tree[x]) {
			if (!visit[i]) {
				parent[i] = x;
				dfs(i);
			}
		}
	}
}

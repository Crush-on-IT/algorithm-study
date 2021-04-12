package BFS_DFS;
import java.io.*;
import java.util.*;

public class 백준_2606_바이러스 {
	static int N;
	static int pair;
	static int[][] computer;
	static boolean visit[];
	static StringBuilder sb;
	static int cnt;

	// dfs사용

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		pair = Integer.parseInt(br.readLine()); // 쌍의 수
		computer = new int[N + 1][N + 1];

		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			computer[from][to] = computer[to][from] = 1;
		}

		visit = new boolean[N + 1];
		dfs(1);
		System.out.println(cnt);

	}

	static void dfs(int point) { // 간선의 개수
		visit[point] = true;
		for (int i = 1; i <= N; i++) {
			if (computer[point][i] == 1 && !visit[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
}

package Shortest_Path;

import java.io.*;
import java.util.*;

public class 백준_1956_운동_saeumi {

	private static int INF = 10000 * 400 + 1;
	private static int answer  = 10000 * 400 + 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int map[][] = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			Arrays.fill(map[i], INF);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;

		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			answer = Math.min(map[i][i], answer); // 다시 자기 한테 되돌아오니까
		}

		if (answer == INF) {
			System.out.println(-1);
		} else
			System.out.println(answer);

	}

}

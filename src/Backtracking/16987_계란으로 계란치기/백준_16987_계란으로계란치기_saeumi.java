package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_16987_계란으로계란치기_saeumi {
	static int N, cnt, max, durability[], weight[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		durability = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int now) {
		if (now == N)
			return;
		for (int i = 0; i < N; i++) {
			if (now == i)
				continue; // 자신이므로 skip
			if (durability[i] <= 0)
				continue; // 깨진 계란이므로 skip
			if (durability[now] <= 0) { // 현재계란이 깨졌으면 다음으로 넘어가자.
				dfs(now + 1);
			} else {
				// visited= true
				durability[now] -= weight[i];
				durability[i] -= weight[now];
				if (durability[now] <= 0)
					cnt++; // 깨진계란
				if (durability[i] <= 0)
					cnt++; // 깨진계란

				max = Math.max(max, cnt);
				dfs(now + 1);

				// 사용끝났으니까 원상태로 돌리기 visited=false
				if (durability[now] <= 0)
					cnt--; // 깨진계란
				if (durability[i] <= 0)
					cnt--; // 깨진계란
				durability[now] += weight[i];
				durability[i] += weight[now];
			}
		} // end of for
	} // end of dfs

} // end of class
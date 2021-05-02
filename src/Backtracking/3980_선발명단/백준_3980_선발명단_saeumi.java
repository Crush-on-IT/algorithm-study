package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_3980_선발명단_saeumi {

	private static boolean[] visited;
	private static int[][] arr;
	private static int max = Integer.MIN_VALUE;
	private static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			arr = new int[12][12];
			max = Integer.MIN_VALUE;

			for (int i = 1; i <= 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[12];
			dfs(1,0);
			System.out.println(max);
		}
	} // end of main

	private static void dfs(int count, int sum) {
		
		if(count ==12) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=1; i<=11; i++) {
			if(visited[i]) continue;
			if(arr[count][i] ==0 )continue;
			
			visited[i] = true;
			dfs(count+1, sum + arr[count][i]);
			visited[i] = false;
		}

	}

} // end of class

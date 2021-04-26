package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15649_N과M_1_saeumi {

	private static int N, M;
	private static int[] arr;
	private static boolean[] visit;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M]; // 1부터 시작이니까
		visit = new boolean[N + 1];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int count) {

		//dfs탈출 == > 뽑은 개수가 M개와 동일하다면 
		if(count == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		
		//뽑지 않은 것 -> dfs 재귀 호출
		for(int i =1; i<=N; i++) 
			if(!visit[i]) { //방문하지 않았다면
				visit[i] = true;
				arr[count]= i; //뽑기 
				dfs(count+1); //그 다음 값 뽑기 위해서 재귀호출
				visit[i] = false; //뽑은 뒤 미방문 처리 
			}
		}
	}

 

package Divide_Conquer;

import java.io.*;
import java.util.*;

public class 백준_4256_트리_saeumi {

	private static int[] preorder, inorder;
	private static int N;
	private static StringBuilder sb;
	private static int TC;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			inorder = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inorder[j] = Integer.parseInt(st.nextToken());
			}
			dfs(0, N, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int end, int index) {

		for (int i = start; i < end; i++) {
			if (inorder[i] == preorder[index]) {
				dfs(start, i, index + 1);
				dfs(i + 1, end, index + 1 + i - start);
				sb.append(preorder[index]).append(" ");
			}
		}
	}
}

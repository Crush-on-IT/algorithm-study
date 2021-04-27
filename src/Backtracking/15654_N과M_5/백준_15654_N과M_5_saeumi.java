package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15654_N과M_5_saeumi { // 순열

	private static int N, M;
	private static int[] numbers;
	private static boolean[] isChecked;
	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //주어진 숫자의 개수 
		M = Integer.parseInt(st.nextToken()); // 뽑을 숫자 !!! 

		st = new StringTokenizer(br.readLine());
		numbers = new int[M]; //
		isChecked = new boolean[N + 1];  //숫자가 나왔는지 안 나왔는지 체크할 배열
		arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		perm(0);
		System.out.println(sb);
	}

	private static void perm(int count) {

		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isChecked[i]) {
				continue;
			}
			isChecked[i] = true;
			numbers[count] = arr[i];
			perm(count + 1);
			isChecked[i] = false;
		}
	}

}

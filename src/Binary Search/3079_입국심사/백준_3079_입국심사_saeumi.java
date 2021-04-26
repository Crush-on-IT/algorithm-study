package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_3079_입국심사_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}

		Arrays.sort(arr);

		long left = 0;
		long middle;
		long right = (long) max * M;
		long answer = 0;

		while (right >= left) {

			middle = (right + left) / 2;
			long countNum = 0;

			for (int i = 0; i < N; i++) {
				countNum += middle / arr[i];
			}

			if (countNum >= M) {
				right = middle - 1;
				answer = middle;

			} else {
				left = middle + 1;
			}
		}
		System.out.println(answer);
	}

}

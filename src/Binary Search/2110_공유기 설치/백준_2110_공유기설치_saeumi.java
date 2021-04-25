package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_2110_공유기설치_saeumi { // 파라매트릭 서치문제 !

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기 개수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int min = 1; // 최소거리
		int middle;
		int max = arr[N - 1] - arr[0]; // 최대 거리
		int answer = 0;

		while (max >= min) {

			middle = (max + min) / 2;

			int shareCount = 1;
			int start = arr[0];

			for (int i = 1; i < N; i++) {

				int distance = arr[i] - start;
				if (middle <= distance) {
					++shareCount;
					start = arr[i];
				}
			}

			if (shareCount >= C) {
				min = middle + 1;
				answer = middle;
			} else
				max = middle - 1;
		}

		System.out.println(answer);

	} // end of main
} // end of class

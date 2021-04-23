package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_1654_랜선자르기_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long middle =0;
		long max = arr[K - 1];
		long min = 1;

		while (max >= min) {
			middle = (max + min) / 2;
			long LineCount = 0;

			for (int i = 0; i < K; i++) {
				LineCount += arr[i] / middle;
			}

			// N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
			if (LineCount >= N) {
				min = middle + 1;
			} else if (LineCount < N) {
				max = middle - 1;
			}
		}
		System.out.println(max);
	}
} // end of main

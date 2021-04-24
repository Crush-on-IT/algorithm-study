package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_1477_휴게소세우기_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = 0;
		arr[N + 1] = L;
		Arrays.sort(arr);

		int middle;
		int max = L;
		int min = 0;

		while (max >= min) {

			middle = (max + min) / 2;
			int restCount = 0;

			for (int i = 1; i < N + 2; i++) {
				restCount += (arr[i] - arr[i - 1] -1) / middle; //마지막에 겹쳐지니까 
			}
 			
				if (restCount > M) {
					min = middle + 1;
				} else {
					max = middle - 1;
				}
			}
			System.out.println(min);

	} // end of main

} // end of class

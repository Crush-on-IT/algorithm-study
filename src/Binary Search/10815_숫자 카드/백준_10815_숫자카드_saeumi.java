package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_10815_숫자카드_saeumi {

	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		  arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = BinarySearch(Integer.parseInt(st.nextToken()));
			if(num != -1)  
				System.out.print(1 + " ");
			  else  
				System.out.print(0 + " ");
			 
		}
	}

	private static int BinarySearch(int number) {

		int left = 0;
		int right = arr.length - 1;
		int middle;

		while (left <= right) {
			middle = (left + right) / 2;
			if (arr[middle] < number)
				left = middle + 1;
			else if (arr[middle] > number)
				right = middle - 1;
			else
				return middle;
		}
		return -1;
	} // end of main

} // end of class

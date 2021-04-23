package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_2512_예산_saeumi {

	static int arr[];
	static int Budget;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		Budget = Integer.parseInt(br.readLine());

		if (Budget >= sum)
			System.out.println(arr[N - 1]);
		else
			BinarySearch();
	}

	private static void BinarySearch() {

		int max = Budget; // max가 Budget으로 설정해놓은거지, Budget이 max가 아님을 기억하기 !
		int min = 0;
		int middle;

		while (max >= min) {
			int BudgetSum = 0;
			middle = (min + max) / 2;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > middle) {
					BudgetSum += middle;
				} else {
					BudgetSum += arr[i];
				}
			}

			if (BudgetSum > Budget) {
				max = middle - 1;
			} else
				min = middle + 1;

		}
		System.out.println(max);

	}
}

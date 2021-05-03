package Dynamic_programming;

import java.util.*;

public class 백준_2748_피보나치수2_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();

		long arr[] = new long[91];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= A; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[A]);
	}
}

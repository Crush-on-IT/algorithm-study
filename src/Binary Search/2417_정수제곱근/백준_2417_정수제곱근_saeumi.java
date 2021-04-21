package Binary_search;

import java.util.*;

public class 백준_2417_정수제곱근_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long left = 0;
		long right = n;
		long min = Long.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;
			long value = (long) Math.pow(mid, 2);

			if (value >= 0) {
				if (value >= n) {
					min = Math.min(min, mid);
					right = mid - 1;

				} else
					left = mid + 1;
			}
		}
		System.out.println(min);
	}
}

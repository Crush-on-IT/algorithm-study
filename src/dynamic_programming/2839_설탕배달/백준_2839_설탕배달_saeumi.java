package Dynamic_programming;

import java.util.*;

public class 백준_2839_설탕배달_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;

		while (true) {
			if (a % 5 == 0) {
				count += a / 5;
				System.out.println(count);
				return;
			} else {
				a -= 3;
				count++;
			}
			
			if( a<0) {
				System.out.println(-1);
				break;
			}
		} // end of while
	}
}

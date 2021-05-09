import java.util.Scanner;

public class BOJ_2839_설탕배달_oct14jh {
	private static int N;
	private static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		while(true) {
			if(N % 5 == 0) {
				System.out.println((N/5) + result);
				System.exit(0);
			}
			if(N <= 0) {
				System.out.println(-1);
				System.exit(0);
			}
			N -= 3;
			result++;
		}
		
	}
}

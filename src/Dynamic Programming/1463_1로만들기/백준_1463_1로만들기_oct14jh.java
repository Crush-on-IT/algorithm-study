import java.util.Scanner;

public class 백준_1463_1로만들기_oct14jh {
	private static int N;
	private static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dfs(0, N);
		System.out.println(result);
	}
	
	private static void dfs(int count, int x) {
		if(x == 1) {
			result = Math.min(count, result);
			return;
		}
		if(result < count) {
			return;
		}
		
		if(x%3 == 0)
			dfs(count + 1, x/3);
		if(x%2 == 0)
			dfs(count + 1, x/2);
		dfs(count + 1, x-1);
	}
}

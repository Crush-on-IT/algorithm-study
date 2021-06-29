import java.util.Scanner;
 
public class 백준_15652_N과M4_oct14jh {
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();

		arr = new int[M];
 
		dfs(1, 0);

		System.out.println(sb); 
	}
 
	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
	}
 
}
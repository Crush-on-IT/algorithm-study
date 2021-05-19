import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int f[] = new int[N + 1];
		int memo[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			f[i] = Integer.parseInt(br.readLine());
		}
		memo[1] = f[1];
		memo[2] = f[2] + f[1];
		memo[3] = Math.max(f[1] + f[3], f[2] + f[3]);
		for (int i = 3; i <= N; i++) {
			memo[i] = Math.max(memo[i - 3] + f[i] + f[i - 1], memo[i - 2] + f[i]);
		}
		System.out.println(memo[N]);
	}
}

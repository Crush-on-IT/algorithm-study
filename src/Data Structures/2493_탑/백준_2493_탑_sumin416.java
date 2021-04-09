import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cur = 0, top = 0;
		for (int i = 1; i <= N; i++) {
			cur = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				top = stack.peek()[1];

				if (top <= cur) {
					stack.pop();
				} 
				else
					break;
			}

			sb.append(stack.isEmpty()?0:stack.peek()[0]).append(" ");
			stack.push(new int[] { i, cur });

		}
		System.out.println(sb.toString());
	}

}

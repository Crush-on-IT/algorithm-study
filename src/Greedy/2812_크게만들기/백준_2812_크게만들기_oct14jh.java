package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812_크게만들기_oct14jh {

	private static int N, K;
	private static char[] expr;
	private static Stack<Character> stack = new Stack<>();
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		expr = new char[N];
		expr = br.readLine().toCharArray();
		
		process();
		
		System.out.println(sb.reverse().toString().substring(0, sb.length()-K));
		br.close();
	}

	private static void process() {
		for(int i = 0; i < expr.length; i++) {
			while(!stack.isEmpty() && K > 0 && stack.peek() < expr[i]) {
				stack.pop();
				K--;
			}
			stack.push(expr[i]);
		}
		
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop().toString());
		}
	}
}


package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_9012_괄호_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String answer = "YES";
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(') {
					stack.push(c);
				}

				else if (c == ')') {
					if (stack.isEmpty()) {
						answer = "NO";
						break;
					} else {
						stack.pop();
					}
				}

			}

			if (!stack.isEmpty()) {
				answer = "NO";
			}
			System.out.println(answer);
		}
	}
}

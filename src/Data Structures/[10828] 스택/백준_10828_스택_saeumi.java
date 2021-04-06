package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_10828_스택_saeumi{

	public static void main(String[] args) throws NumberFormatException, IOException {

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			if (input.contains("push")) {
				int input2 = sc.nextInt();
				stack.push(input2);
			} else if (input.equals("pop")) {
				sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
			} else if (input.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (input.equals("empty")) {
				sb.append(stack.empty() ? 1 : 0).append("\n");
			} else if (input.equals("top")) {
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
			}
		}
		System.out.println(sb);
	} // end of main
} // end of class

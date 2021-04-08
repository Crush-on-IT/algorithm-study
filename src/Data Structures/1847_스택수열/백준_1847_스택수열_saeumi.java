package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1847_스택수열2_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		ArrayList<Character> result = new ArrayList<>();

		int start = 1;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());

			while (start <= temp) {
				stack.push(start);
				start++;
				result.add('+');
			}

			if (stack.peek() == temp) {
				stack.pop();
				result.add('-');
			} else {
				System.out.println("NO");
				return;
			}
		}

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	} // end of main
} // end of class

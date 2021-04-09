package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1918_후위표기식_saeumi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		// HashMap 사용해서 key - value 값 짝 지어주기
		HashMap<Character, Integer> map = new HashMap<>(); // HashMap 중복 가능
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// 알파벳
			if ('A' <= c && c <= 'Z') {
				sb.append(c);
				continue;
			}

			// 여는 괄호 일 때
			if (c == '(') {
				stack.push(c);
				continue;
			}

			// 닫는 괄호일 때
			if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}
				continue;
			}

			// 연산자 일때
			while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c))
				sb.append(stack.pop());
			stack.push(c);
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}

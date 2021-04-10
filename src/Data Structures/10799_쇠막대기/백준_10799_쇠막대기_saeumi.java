package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_10799_쇠막대기_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<String> stack = new Stack<String>();

		int sum = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(')
				stack.push("("); // 일단 push
			else { // 닫는 괄호일 때
				if (str.charAt(i - 1) == '(') { // 직전 괄호가 여는 괄호 였으면 --> 레이저라면
					stack.pop(); // 여는 괄호 날리고
					sum += stack.size(); //

				} else { // 직전 괄호가 닫는 괄호 였으면
					stack.pop(); // 날리기
					sum += 1;
				}
			}
		}
		System.out.println(sum);

	} // end of main
} // end of class

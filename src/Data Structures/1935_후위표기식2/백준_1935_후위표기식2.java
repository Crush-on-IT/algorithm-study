package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1935_후위표기식2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //입력값 
		double[] number = new double[N];
		
		char[] arr = br.readLine().toCharArray(); //후위표기식을 char별로 가지고 옴 
		Stack<Double> stack = new Stack<Double>();
		

		for(int i=0; i<N; i++) { 
			number[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i =0; i<arr.length; i++) { //arr.length만큼 반복 돌기 
			char c = arr[i];
			if(!Character.isUpperCase(c)) {
				double a = stack.pop(); //꺼내기
				double b = stack.pop();
				
				switch (c) {
				case '+':
					stack.push(b+a);
					break;
				case '-':
					stack.push(b-a);
					break;
				case '*':
					stack.push(b*a);
					break;
				case '/':
					stack.push(b/a);
					break;
 
				}
			} else { //집어넣기
				stack.push(number[c-'A']);
			}
		}
			
		System.out.printf("%.2f", stack.pop());
	}

}

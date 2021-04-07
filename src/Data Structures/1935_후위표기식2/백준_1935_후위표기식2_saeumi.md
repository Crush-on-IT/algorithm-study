# 백준_1935_후위표기식2 

### &#127795; 분류 

Stack

### &#127795; 코드

```java
package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1935_후위표기식2_saeumi {

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

```



### &#127795; 풀이 방법 

1.  후위표기식을 통해 값을  출력하는 문제이다

2. Stack <> 에 계산 후 값을 위해 double형을 지정해 주었고

3. 받아온 입력값이 알파벳이 아니라면 switch 문제 들어가서 a,b (전에 들어온 값들) 을 연산해주고

4. 알파벳이라면 number배열에서  'A' 크기만큼의 배열을 빼주고 stack에 push 해주었다.

   

### &#127795; 느낀점 

 
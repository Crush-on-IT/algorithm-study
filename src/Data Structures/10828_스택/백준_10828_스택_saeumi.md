# 백준10828_스택

### &#127795; 분류 

Stack

### &#127795; 코드

```java
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

```



### &#127795; 풀이 방법 

1.  이 문제는 문제에서 구현하라고 하는 것 그대로 하면 되는 것 같다

2. push, pop. size, empty, top 마다 조건문을 걸어주고 

3. 그에 맞는 출력을 하도록 하였다. 

   

### &#127795; 느낀점 

 280ms 인데 조금 더 줄일 수 있는 방법을 생각해야겠다
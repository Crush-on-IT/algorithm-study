# 백준_1847_스택수열

### &#127795; 분류 

Stack

### &#127795; 코드

```java
package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1847_스택수열 {

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

```



### &#127795; 풀이 방법 

1.  이 문제는 문제에서 구현하라고 하는 것 그대로 하면 되는 것 같다

2.  시작숫자보다 입력값에서 받아온 순자가 크거나 같으면 하나씩 push 해주면서 더해주고,

3. temp 값이 stack.peek와 같다면 꼭대기 값을 pop해주고 -를 출력한다. 

4. 마지막으로 스택 수열을 할 수없다면 No를 출력해주면 된다.

   

### &#127795; 느낀점 

처음엔 문제 이해가 어려웠지만 스택을 알고나면 쉽게 풀 수 있는 문제였다.
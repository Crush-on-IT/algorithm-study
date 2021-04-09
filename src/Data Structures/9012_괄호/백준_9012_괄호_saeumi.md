# 백준_9012_괄호

### &#127795; 분류 

Stack

### &#127795; 코드

```java
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

```



### &#127795; 풀이 방법 

1.  답의 초기값을 answer로 지정을 하고 시작하였다.
2.  입력을 한 줄씩 받고, 문자열을 하나씩 쪼개서 만약 ( 이면 push 해주고
3.  )  이라면 2가지의 경우로 나누어 (스택이 비어있는 경우, 그렇지 않은 경우) 로 계산한다.

### &#127795; 느낀점 

다른 방법을 알기 위해 구글링을 해 본 결과 count를 사용하여 stack대신 사용한 경우를 보았다. 

 
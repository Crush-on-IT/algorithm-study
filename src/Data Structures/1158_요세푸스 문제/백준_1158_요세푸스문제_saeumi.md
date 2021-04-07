# 백준_1158_요세푸스문제

### &#127795; 분류 

Queue

### &#127795; 코드

```java
package Data_Structures;

import java.util.*;

public class 백준_1158_요세푸스문제 {

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int K = sc.nextInt();

	Queue<Integer> q = new LinkedList<Integer>();
	for (int i = 1; i <= N; i++) {
		q.offer(i);
	}

	StringBuilder sb = new StringBuilder();
	sb.append("<");

	while (q.size() != 1) { // N명의 사람이 제거 될 때까지 하니까
		for (int i = 0; i < K - 1; i++) {
			q.offer(q.poll());  
		}
		sb.append(q.poll() + ", ");
	}
	sb.append(q.poll() + ">"); //마지막꺼 
	System.out.println(sb);
}
}
```



### &#127795; 풀이 방법 

1. 큐에 N까지의 사람을 전부 다 넣기 

2. 문제에서 N명의 사람이 제거 될 때까지 진행하기 때문에 

   앞의 숫자를 뒤로 입력시키며 큐를 순회 하다가 

3. 해당 순번이 되면 큐를 poll해서 

4. 마지막 남아있는 것까지 더해주고 (sb.append)

5. StringBuilder 담아서 마지막에 출력하기 

   

### &#127795; 느낀점 

 역시 큐는 큐다 
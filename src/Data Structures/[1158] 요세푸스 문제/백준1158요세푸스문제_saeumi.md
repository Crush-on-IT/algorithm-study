# 백준_1158_요세푸스문제_saeumi

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
			q.offer(q.poll()); //offer(poll()) : 앞의 숫자를 뒤로 입력시키며 큐를 순회하다가 
			 						// 해당 순번이 되면 큐를 poll해서 출력 
		}
		sb.append(q.poll() + ", ");
	}
	sb.append(q.poll() + ">"); //마지막꺼 
	System.out.println(sb);
}
}
```


# 백준_2164_카드2 

### &#127795; 분류 

Queue

### &#127795; 코드

```java
package Data_Structures;

import java.util.*;

public class 백준_2164_카드2 {  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i ++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			for(int i =0; i<=N-2; i++) {
				queue.remove();
				queue.offer(queue.poll());
			}
		}
		System.out.println(queue.poll());
		
	}

}

```



### &#127795; 풀이 방법 

​		백준 요세푸스랑 거의 똑같은 문제다

2. 일단 하나씩 만들어주고 queue.size가 1이 아닐 때까지 while문을 돈다. 

3. 추가로 문제에서 마지막 하나를 남기라고 했기 때문에 N-2 까지만 for문을 돈다.

   queue.remove는 뽑고 버려버리고, queue.poll은 뽑고 버리지는 않는다 ! 
   
   

### &#127795; 느낀점 

 쉬웠다 ! 


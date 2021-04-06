# 백준_10866_덱 

### &#127795; 분류 

Deque

### &#127795; 코드

```java
package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_10866_덱_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.contains("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			} else if (str.contains("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			} else if (str.contains("pop_front")) {
				sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
			} else if (str.contains("pop_back")) {
				sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
			} else if (str.contains("size")) {
				sb.append(deque.size()).append("\n");
			} else if (str.contains("empty")) {
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			} else if (str.contains("front")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
			} else if (str.contains("back")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
			}

		}

		System.out.println(sb);

	}
}

```



### &#127795; 풀이 방법 

1. 이 문제는 문제에서 구현하라고 하는 것 그대로 하면 되는 것 같다. 메소드만 알고 있다면 쉬운 문제 ! 

   


### &#127795; 느낀점 

deque 메소드 기억하기 ! 



#### addFirst()

덱의 앞쪽에 엘리먼트를 삽입한다. 용량 제한이 있는 덱의 경우, 용량을 초과하면 예외(Exception)가 발생한다

#### offerFirst()

덱의 앞쪽에 엘리먼트를 삽입한다. 정상적으로 엘리먼트가 삽입된 경우 true가 리턴되며, 용량 제한에 걸리는 경우 false를 리턴한다. 

#### addLast() = add()

덱의 마지막 쪽에 엘리먼트를 삽입한다. 용량 제한이 있는 덱의 경우, 용량 초과시 예외가 발생한다

#### offerLast()

덱의 마지막 쪽에 엘리먼트를 삽입한다. 정상적으로 엘리먼트가 삽입된 경우 true가 리턴되며, 용량 제한에 걸리는 경우 false를 리턴한다. 



#### removeFirst() = remove() 

덱의 앞쪽에서 엘리먼트 하나를 뽑아서 제거한 다음 해당 엘리먼트를 리턴한다. 덱이 비어있으면 예외가 발생한다. 

#### pollFirst() = poll()

덱의 앞쪽에서 엘리먼트 하나를 뽑아서 제거한 다음 해당 엘리먼트를 리턴한다. 덱이 비어있으면 null 이 리턴된다. 

#### removeLast()

덱의 마지막 쪽에서 엘리먼트 하나를 뽑아서 제거한 다음 해당 엘리먼트를 리턴한다. 덱이 비어있으면 예외가 발생한다. 

#### pollLast()

덱의 마지막 쪽에서 엘리먼트 하나를 뽑아서 제거한 다음 해당 엘리먼트를 리턴한다. 덱이 비어있으면 null 이 리턴된다. 



#### getFirst()

덱의 앞쪽 엘리먼트 하나를 제거하지 않은채 리턴한다. 덱이 비어있으면 예외가 발생한다

#### peekFirst() =peek()

덱의 앞쪽 엘리먼트 하나를 제거하지 않은채 리턴한다. 덱이 비어있으면 null이 리턴된다. 

#### getLast()

덱의 마지막쪽 엘리먼트 하나를 제거하지 않은채 리턴한다. 덱이 비어있으면 예외가 발생한다. 

#### peekLast()

덱의 마지막 엘리먼트 하나를 제거하지 않은 채 리턴한다. 덱이 비어있으면 null이 리턴된다. 

 
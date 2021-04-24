# 백준_1477_휴게소세우기

### &#127795; 분류 

Binary Search 

### &#127795; 코드

```java
package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_1477_휴게소세우기_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = 0;
		arr[N + 1] = L;
		Arrays.sort(arr);

		int middle;
		int max = L;
		int min = 0;

		while (max >= min) {

			middle = (max + min) / 2;
			int restCount = 0;

			for (int i = 1; i < N + 2; i++) {
				restCount += (arr[i] - arr[i - 1] -1) / middle; //마지막에 겹쳐지니까 
			}
 			
				if (restCount > M) {
					min = middle + 1;
				} else {
					max = middle - 1;
				}
			}
			System.out.println(min);

	} // end of main

} // end of class

```



### &#127795; 풀이 방법 

1.   이분탐색의 기본적인 틀에서 주어진 배열의 크기를 늘리고 시작점과 끝점을 고려해 주었다
2.  이분탐색의 기본인 ! 정렬과 while문으로 돌려주기를 실행시키고 
3.  restCount로 휴게소의 갯수를 증가시켜줄 때 (arr[i] - arr[i - 1] -1) 을 통해 이미 휴게소가 세워져있는 마지막 지점을 고려하지 않도록 만들어 주었다.
4.  restCount 가 M(세우고자 하는 휴게소의 개수) 보다 많다면 min = middle +1 을 해주고 아니라면 max = middle -1을 해준다 (이 부분은 기존의 이분탐색과 동일 ! )

### &#127795; 느낀점 

처음에 restCount += (arr[i] - arr[i - 1] ) / middle;로 문제를 풀어서 틀렸다. 마지막지점을 고려해 주지 않았다는 것이다. 물론 for문 안에서 if문을 걸어서 (arr[i] - arr[i - 1]) % middle ==0 으로 빼고 --restCount를 해주어도 되지만, for문 안에 한 번에 썼다 ! 


# 백준_15650_N과M_2_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15650_N과M_2_saeumi {// 조합

	private static int N, M;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];

		comb(0,1);
		System.out.println(sb);

	}

	private static void comb(int count, int start) {

		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <=  N; i++) {
			numbers[count] = i;
			comb(count + 1, i + 1);
		}

	}

}


```



### &#127795; 풀이 방법 

1. 조합을 이용한 가장 기본적인 문제 ! 
2. for (int i = start; i <=  N; i++) {
   			numbers[count] = i;
   			comb(count + 1, i + 1); 기억해줘야하는 건 이것만 ! 

### &#127795; 느낀점 

 조합 감 잡았지롱 


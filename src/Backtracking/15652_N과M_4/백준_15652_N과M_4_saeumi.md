# 백준_15652_N과M_4_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15652_N과M_4_saeumi {

	private static int[] numbers;
	private static int N, M;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		comb(0, 1);
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
		for (int i = start; i <= N; i++) {
			numbers[count] = i;
			comb(count + 1, i);
		}

	}

}



```



### &#127795; 풀이 방법 

1. 	for (int i = start; i <= N; i++) {
   			numbers[count] = i;
   			comb(count + 1, i);

### &#127795; 느낀점 

중복조합 알겠다~!~!~! 

 
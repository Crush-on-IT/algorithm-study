# 백준_1182_부분수열의합_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_1182_부분수열의합_saeumi { // 부분집합!

	private static int[] arr;
	private static int N, S;
	private static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Subset(0, 0, 0);
		System.out.println(answer);
	} // end of main

	private static void Subset(int index, int sum, int count) {
		if (index == N) {
			if (count != 0 && sum == S) {
				answer++;
			}
			return;
		}

		Subset(index + 1, sum + arr[index], count + 1); // 인덱스 더하기 (선택o)
		Subset(index + 1, sum, count); //인덱스 더하지 않기 (선택x)
	}
} // end of class

```



### &#127795; 풀이 방법 

1. N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램이다
2. 부분집합에서 숫자를 선택하는 경우와 선택하지 않은 경우로 나누어서 처리하고 
3. index가 N이 되었을 때, 문제에서 요구한 S가 되면 answer을 증가시켜준다 .



### &#127795; 느낀점 

 부분집합에 대한 기본적인 문제 !
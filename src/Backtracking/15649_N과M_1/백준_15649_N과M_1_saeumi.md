# 백준_15649_N과M_1_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15649_N과M_1_saeumi {

	private static int N, M;
	private static int[] numbers;
	private static boolean[] isSelected;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M]; // 1부터 시작이니까
		isSelected = new boolean[N + 1];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int count) {

		// dfs탈출 == > 뽑은 개수가 M개와 동일하다면
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		// 뽑지 않은 것 -> dfs 재귀 호출
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			numbers[count] = i; // 뽑기
			dfs(count + 1); // 그 다음 값 뽑기 위해서 재귀호출
			isSelected[i] = false; // 뽑은 뒤 미방문 처리
		}
	}
}


```



### &#127795; 풀이 방법 

1. Backtracking에서 순열을 이용한 문제이다. 1부터 N까지 자연수 중에서  중복없이 M개를 고른 수열을 뽑아야 한다.
2. 먼저 for문을 돌면서 뽑은 것과 뽑지 않았던 것들을 구별할 방문 배열 isChecked를 설정해 주고 계속 방문처리를 체크하면서  
3. 뽑고자 했던 M개가 되었을 때 하나하나 뽑아야주어야 하는 문제이다.

### &#127795; 느낀점 

순열의 가장 기본문제이지만, 그냥 수도코드만 외웠던 나에게는 이해하며 다시 풀기가 어려웠다. 디버깅을 하면서 sb에 결과값들이 쌓이는 과정을 보면서 비로소 순열에 대한 이해를 하는 시간이 되었다. ㅎㅎ


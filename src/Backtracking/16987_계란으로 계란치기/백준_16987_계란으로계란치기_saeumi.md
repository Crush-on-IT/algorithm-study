# 백준_16987_계란으로계란치기_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_16987_계란으로계란치기_saeumi {
	static int N, cnt, max, S[], W[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		W = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int now) {
		if (now == N)
			return;
		for (int i = 0; i < N; i++) {
			if (now == i)
				continue; // 자신이므로 skip
			if (S[i] <= 0)
				continue; // 깨진 계란이므로 skip
			if (S[now] <= 0) { // 현재계란이 깨졌으면 다음으로 넘어가자.
				dfs(now + 1);
			} else {
				// visited= true
				S[now] -= W[i];
				S[i] -= W[now];
				if (S[now] <= 0)
					cnt++; // 깨진계란
				if (S[i] <= 0)
					cnt++; // 깨진계란

				max = Math.max(max, cnt);
				dfs(now + 1);

				// 사용끝났으니까 원상태로 돌리기 visited=false
				if (S[now] <= 0)
					cnt--; // 깨진계란
				if (S[i] <= 0)
					cnt--; // 깨진계란
				S[now] += W[i];
				S[i] += W[now];
			}
		} // end of for
	} // end of dfs

} // end of class
```



### &#127795; 풀이 방법 

1. 입력을 받고, 내구도의 값과 무게의 값을 각각 durability 배열과 weight 배열에 저장한다.
2.  dfs 메소드로 이동 후 for문을 돌면서 if문을 걸어 현재 계란, 깨진 계란을 고려해준다.
3. 내구도 - 무게 뺀 게 0보다 작다면 (문제의 조건) cnt ++ 
4. 다음 단계로 넘어가는 걸 반복하면 된다. 
5. 사용하고 난 것들은 원상태로  되돌려주는 작업을 해준다. 
6. now가 N이 되면 빠져나온다. 



### &#127795; 느낀점 

처음에는 조합으로 계란 구성을 하려다가 실패하고 dfs로 풀었다. dfs 메소드 안에서 신경써줘야 할 게 많았다. 원래 싫은데 더 싫어졌다 계란
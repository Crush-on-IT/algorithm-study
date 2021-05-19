# 백준_1010_다리놓기_saeumi

### &#127795; 분류 

DP

### &#127795; 코드

```java
package Dynamic_programming;

import java.io.*;
import java.util.*;

public class 백준_1010_다리놓기_saeumi { //mCn

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N+1][M+1];
			
			for(int n=2; n<=N; n++) {
				arr[n][1] =0;
			}
			
			for(int m=1; m<=M; m++) {
				arr[1][m] =m;
			}
			
			for(int i=2; i<=N; i++) {
				for(int j =2; j<=M ; j++) {
					arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
				}
			}
			
			System.out.println(arr[N][M]);
		}
	}

}

```



### &#127795; 풀이 방법 

1. 	DP를 활용한 조합문제이다.
2. 	DP는 기본적으로 규칙을 찾거나 테이블을 그려줘야 하는 것 같다. 
3. 	이 문제에서는 mCn으로 생각하고 문제를 풀었고, n=1 일때와 m=1일때의 각각의 값을 테이블에 정해두고, 나머지 값들은 반복문을 돌면서 처리해 주었다. 


### &#127795; 느낀점 

 단순히 조합문제였지만, 재귀로 조합을 하면 실패가 떴다. ㅠㅠ 
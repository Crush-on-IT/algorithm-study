# 백준_1463_1로만들기_saeumi

### &#127795; 분류 

DP

### &#127795; 코드

```java
	package Dynamic_programming;

import java.util.*;

public class 백준_1463_1로만들기_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] dp = new int[a + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= a; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[a]);

	}

}

```



### &#127795; 풀이 방법 

1. 	이 문제는 DP를 이용해야한다. 
2. 	1부터 차례차례 직접 해보면 규칙이 나오는데 
3. 	그 규칙을 DP에 넣기 위해 배열을 선언하고 , 그 규칙에 맞도록 로직을 구현하면 된다.

* 규칙 : 2나 3으로 나누어 떨어지지 않으면, 그 전꺼 +1

  ​		2로 나누어 떨어진다면, 1번 규칙과 dp[i/2] +1 비교해서 min 값 지정 

  ​		3로 나누어 떨어진다면, 1번 규칙과 dp[i/3] +1


### &#127795; 느낀점 

싸피에서 풀때도 DP로 안 해서 많이 힘들었는데 같은 실수를 반복했다 ㅎㅎ..
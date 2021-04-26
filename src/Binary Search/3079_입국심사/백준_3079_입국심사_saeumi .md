# 백준_3079_입국심사

### &#127795; 분류 

Binary_search;

### &#127795; 코드

```java
package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_3079_입국심사 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}

		Arrays.sort(arr);

		long left = 0;
		long middle;
		long right = (long) max * M;
		long answer = 0;

		while (right >= left) {

			middle = (right + left) / 2;
			long countNum = 0;

			for (int i = 0; i < N; i++) {
				countNum += middle / arr[i];
			}

			if (countNum >= M) {
				right = middle - 1;
				answer = middle;

			} else {
				left = middle + 1;
			}
		}
		System.out.println(answer);
	}

}

```



### &#127795; 풀이 방법

1. 제일 중요한 right 와 left 값을 구해야하는데 여기에서 right (최댑갓)은  입국심사대마다 걸리는 시간 중 가장 최대의 시간 * 전체 인원 수를 해준다.
2. 그 다음 이분탐색을 진행하게 되는데 , 이 떄 countNum 을 0으로 설정해주고 시작한다. 만약, for문을 돌면서 countNum이 middle/arr[i]  일때의 값을 더해주면서 마지막에 비교하게 된다. 
3. 이 때 가장 최소의 소요시간을 출력하라고 하였기 때문에 answer을 middle에 걸어주고 답을 출력한다. 

### &#127795; 느낀점

 어제 정리한 부분을 다시 한 번 되짚어 볼 수 있었다. 



 
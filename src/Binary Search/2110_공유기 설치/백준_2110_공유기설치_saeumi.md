# 백준_2110_공유기설치

### &#127795; 분류 

Binary_search;

### &#127795; 코드

```java
package Binary_search;

import java.io.*;
import java.util.*;

public class 백준_2110_공유기설치 { // 파라매트릭 서치문제 !

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기 개수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int min = 1; // 최소거리
		int middle;
		int max = arr[N - 1] - arr[0]; // 최대 거리
		int answer = 0;

		while (max >= min) {

			middle = (max + min) / 2;

			int shareCount = 1;
			int start = arr[0];

			for (int i = 1; i < N; i++) {

				int distance = arr[i] - start;

				if (middle <= distance) {
					++shareCount;
					start = arr[i];
				}
			}

			if (shareCount >= C) {
				min = middle + 1;
				answer = middle;
			} else
				max = middle - 1;
		}

		System.out.println(answer);

	} // end of main

} // end of class

```



### &#127795; 풀기 전 ! 

* 풀기 전 알면 좋은 지식 - 파라매트릭 서치 ( Parametric Search)

  : 이분탐색과 매우 유사하지만, 결정문제를 최적화 문제로 바꾸어 푸는 것에서 차이점이 있다.

  이 말은 즉슨 ! 

  예를 들어, 자동차를 탈 수 있나요? 라는 질문에 5 가 아니라고 대답했다면, 

  ![image-20210425211956890](C:\Users\saeum\AppData\Roaming\Typora\typora-user-images\image-20210425211956890.png)

  5 이하의 모든 사람들은 자동차를 탈 수 없다 ! 

  ![image-20210425212031195](C:\Users\saeum\AppData\Roaming\Typora\typora-user-images\image-20210425212031195.png)

  5번까지는 이미 정답 범위에서 제외되었으니 6이 Left, 9가 Right가 될 것이다. 이때 Mid는 7이 될것이고 7에게 질문을 한다. 7은 자동차를 탈 수 있다고 한다. 문제의 가정에 의해 19세 이상은 자동차를 탈 수 있고 나이순으로 정렬되어 있으니 7번 이후의 사람들은 모두 정답 후보에 포함된다.

  그렇다고 7번이 자동차를 탈 수 있는 가장 어린사람이라고 할 수 있을까? **그렇지 않다.**

  5번 이하까지만 모두 정답 범위에서 제외될 뿐, 6번에 대한 정보가 아직 없다. 따라서 Left와 RIght를 다시 조절해야한다.

   

  ![image-20210425212230982](C:\Users\saeum\AppData\Roaming\Typora\typora-user-images\image-20210425212230982.png)

  위의 그림처럼 Left와 Right가 6을 향하게 될 것이고, 결국 Mid가 6이 되어 6을 타겟으로 질문을 하게 된다.

  만약 여기서 6이 자동차를 탈 수 있나요의 질문에 네라고 반응한다면 정답은 6이 될 것이고, 아래 그림처럼 아니오라고 말한다면 정답은 7이 될 것이다.

* ![image-20210425212257858](C:\Users\saeum\AppData\Roaming\Typora\typora-user-images\image-20210425212257858.png)

  

### &#127795; 풀이 방법

1. 입력 받고 정렬까지는 기본적인 이분탐색 문제와 동일하다 ! 

2. 일단 문제에서 구하고자 하는 게 공유기 설치가 가능한 최대거리이다. 따라서 최소거리인 1과 최대거리 ( 최대값 - 가장 작은 값) 을 min 과 max에 지정한다. 

3. C의 값이 2부터 시작이기 때문에 shareCount =1로 지정하고, for문을 돌면서 집과 집 사이의 거리를 측정하는데, 그 측정한 거리가 (middle <= distance) 라면 (문제에서 최 ! 대 ! 거리를 구하라고 했으니까 ! ) shareCount를 증가시키고, 시작점을 arr[i] 로 바꿔준다 (여기에서 바로 파라메트릭서치 사용 됌 ! 즉,  위의 예제에서처럼 자동차를 탈 수 있나요에서 6이 아니라면 그 전까지를 다 x 하는 것과 동일 !  ) 

4. 그 후에 shareCount가 설치하고자 했던 공유기의 수(C) 보다 많으면 min = middle +1 을 해준다. 이때의 middle 이 곧 구하고자하는 답(answer) 이 되고 middle + 1 

   

### &#127795; 느낀점

if (shareCount >= C) {
				min = middle + 1;
				answer = middle;
			} else
				max = middle - 1;
		}

는 혁명이었다..



 
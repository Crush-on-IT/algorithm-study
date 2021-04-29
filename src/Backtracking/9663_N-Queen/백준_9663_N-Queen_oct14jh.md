# 백준_9663_N-Queen_oct14jh

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
import java.util.Scanner;

public class 백준_9663_N-Queen_oct14jh {
	private static int N;
	private static int[] list;
	private static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new int[N];
		
		process(0);
		System.out.println(result);
		sc.close();
	}

	private static void process(int line) {
		if(line >= N) {
			result++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			list[line] = i;
			if(check(line))
				process(line + 1);
		}
	}

	private static boolean check(int line) {
		for(int i = 0; i < line; i++) {
			if((list[line] == list[i]) || Math.abs(list[line] - list[i]) == line - i) {
				return false;
			}
		}
		return true;
	}
}

```



### &#127795; 풀이 방법 

1. 2차원 배열로 풀어도 되고 아니여도 가능하다.
2. 조합만 잘 할줄알면, 풀수있다.



### &#127795; 느낀점 

브루트포스 짱...




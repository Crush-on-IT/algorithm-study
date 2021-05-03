# 백준_2839_설탕배달_saeumi

### &#127795; 분류 

dp

### &#127795; 코드

```java
package Dynamic_programming;

import java.util.*;

public class 백준_2839_설탕배달_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;

		while (true) {
			if (a % 5 == 0) {
				count += a / 5;
				System.out.println(count);
				return;
			} else {
				a -= 3;
				count++;
			}
			
			if( a<0) {
				System.out.println(-1);
				break;
			}
		} // end of while
	}
}


```



### &#127795; 풀이 방법 

		1. 최대한 5인 묶음으로 만들어서 설탕을 배달해야 하기 때문에 if문으로 5로 나누어 떨어진다면 바로 그 묶음 만큼 들고 가게 만든다.
  		2. 만약 5로 나누어 떨어지지 않는다면, 3kg도 옮길 수 있기 때문에 a의 무게를 3만큼 빼주면서 count를 더해간다.
  		3. 그렇게 while문을 계속돌다가 만약 a가 음수가 되면 -1을 출력하면 된다 ! 

### &#127795; 느낀점 

 브론즈인데 오래 걸렸다 


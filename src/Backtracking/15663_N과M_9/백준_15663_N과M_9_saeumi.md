# 백준_15663_N과M_9_saeumi

### &#127795; 분류 

Backtracking

### &#127795; 코드

```java
package Backtracking;

import java.io.*;
import java.util.*;

public class 백준_15663_N과M_9_saeumi {

	private static int[] arr, numbers;
	private static StringBuilder sb;
	private static int N, M;
	private static boolean[] isChecked;
	private static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		numbers = new int[M];
		isChecked = new boolean[N];
		answer = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		perm(0);
		answer.forEach(System.out::println);
	}

	private static void perm(int count) {

		if (count == M) {
			sb = new StringBuilder();
			for (int p : numbers)
				sb.append(p).append(' ');
			answer.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isChecked[i])
				continue;
			isChecked[i] = true;
			numbers[count] = arr[i];
			perm(count + 1);
			isChecked[i] = false;

		}
	}
}



```



### &#127795; 풀이 방법 

1. 	기존의 문제에서 나아가 중복된 수를 제거하는 문제이다.
2. 	중복된 수를 제거하기 위해 HashSet을 사용하였다. 

### &#127795; 느낀점 

 HashSet을 사용하지 않고 직접 제거를 하게 되면 시간은 훨씬 줄어들었다.

어떤게 좋은걸까..?

​    
```java
   import java.io.*;
import java.util.Arrays;

public class Main{
    static int n;
    static int m;
    static int[] nums;     // 주어지는 숫자를 저장
    static int[] unique;   // 중복되는 숫자를 빼고 고유 숫자들만 저장
    static int[] selected; // m개를 선택하는 배열
    static int[] count;    // 중복되는 숫자가 몇 번 나오는지 저장
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
   
   
   String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    nums = new int[n];
    unique = new int[n];
    selected = new int[m];
    count = new int[n];
    
    line = br.readLine().split(" ");
    for(int i=0; i < n; i++){
        nums[i] = Integer.parseInt(line[i]);
    }
    
    // 숫자를 미리 정렬시킴
    Arrays.sort(nums);
    
    // 각 숫자를 중복된 개수를 세고 고유 숫자만 따로 저장한다.
    unique = new int[n];
    int current = nums[0];
    int k = 0;
    int cnt = 1;
    for(int i=1; i < n; i++){
        if(nums[i] == current){
            cnt++;
        } else {
            count[k] = cnt;
            unique[k] = current;
            k++;
            cnt = 1;
            current = nums[i];
        }
    }
    count[k] = cnt;
    unique[k] = current;
    go(0);
    
    System.out.println(sb);
    br.close();
}

private static void go(int seq){
    if(seq == m){
        for(int i : selected){
            sb.append(i).append(" ");
        }
        sb.append("\n");
        return;
    }
    
    for(int i=0; i < n; i++){
        // 현재 중복된 숫자를 사용할 수 있는 것이 0개 초과라면
        if(count[i] > 0){
            count[i] -= 1;
            selected[seq] = unique[i];
            go(seq+1);
            count[i] += 1;
        }
    }
}
}
```

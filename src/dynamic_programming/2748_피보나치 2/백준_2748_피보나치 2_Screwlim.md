# 백준2748\_피보나치 2

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline())
arr = [0 for _ in range(N+2)]
arr[1] = 1

for i in range(2, N+1):
    arr[i] = arr[i-1] + arr[i-2]

print(arr[N])
```

### &#127822; 풀이 방법
피보나치 수열의 값을 계산하는 문제이다.

1. 처음 두 값을 0과 1로 지정해둔다.

2. N만큼 수열의 N-1, N-2의 값을 더하며 수열의 값을 채워나간다.

3. 마지막 값을 출력한다.

### &#127822; 느낀점

재귀로도 풀 수 있지만 시간과 메모리가 초과가 날 것 같아 이렇게 풀이하였다.
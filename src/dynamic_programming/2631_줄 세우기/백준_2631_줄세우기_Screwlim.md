# 백준2631\_줄세우기

### &#127822; 분류

Dynamic Programming, LIS(최장증가수열)

### &#127822; 코드

```python
import sys

n = int(sys.stdin.readline().rstrip())
kids = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

dp = [1] * n
for i in range(n):
    for j in range(i):
        if kids[i] > kids[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
```

### &#127822; 풀이 방법

LIS개념이 필요한 문제이다.

현재 순서에서 어긋나게 서있는 아이들의 수를 빼면 원하는 답이 된다.

순서에 어긋나게 서있다는 뜻은 최장증가수열에 어긋나있다고 보면 된다.

따라서 각 원소를 순회하며 현재 자신보다 작은 index의 최장증가수열을 계산하며 이 중 최댓값을 구하면 된다.

원소를 순회하며 최장증가수열의 갯수를 구할 때 memoization이 활용된다.

### &#127822; 느낀점

LIS 알아두자.

memoization 활용법은 떠올리는게 어렵다.
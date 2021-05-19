# 백준1010\_다리 놓기

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys
import math

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    ans = math.factorial(b) // (math.factorial(a) * math.factorial(b - a))
    print(ans)
```

### &#127822; 풀이 방법

단순한 combination문제이다.

1. 좌측 지점의 수만큼 우측 지점을 선택하면 된다.

2. combination의 수를 계산한다.

### &#127822; 느낀점

itertool의 combination을 해보았으나, 시간이 너무 오래 걸려 수학 공식을 구현해 풀었다.
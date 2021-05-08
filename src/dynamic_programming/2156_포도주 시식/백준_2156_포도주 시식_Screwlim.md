# 백준2156\_포도주 시식

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline().rstrip())
wines = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
drink = [0 for _ in range(N)]

if N < 2:
    wines.append(0)
    drink.append(0)

drink[0] = wines[0]
drink[1] = wines[0] + wines[1]

for i in range(2, N):
    drink[i] = max(drink[i-3] + wines[i-1] + wines[i], drink[i-2] + wines[i], drink[i-1])

print(drink[-1])
```

### &#127822; 풀이 방법

2579 계단 오르기와 거의 유사한 문제

여기서는 마지막 지점에 꼭 도달할 필요가 없다는 점만 다르다.

### &#127822; 느낀점

오늘코테로 멘탈 나감
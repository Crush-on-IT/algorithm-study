# 백준2579\_계단 오르기

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline())
steps = [0]*300
for i in range(N):
    steps[i] = int(sys.stdin.readline().rstrip())
maxs_ = [steps[0], steps[0]+steps[1], max(steps[2]+steps[1], steps[2] + steps[0])]
for i in range(3,N):
    maxs_.append(max(steps[i]+maxs_[i-2], steps[i]+steps[i-1]+maxs_[i-3]))

print(maxs_[N-1])
```

### &#127822; 풀이 방법

각 계단까지 최고점은 이전계단의 점수 + 3계단 전까지의 max와 2계단전 까지의 max, 둘 중 최고점에 현재 계단의 점수를 더한 것과 같다.


1. 위 규칙을 수식화 하기 위해서는 index에 -3계산이 들어가기에 1, 2, 3번째 계단까지는  직접 값을 기록한다.

2. 4번째 계단부터는 이전 값, 2로 나눈 값, 3으로 나눈 값이 변환된 횟수를 조회하여 그 중 최소값에 1을 더해 기록한다.

3. N까지 반복한다.

### &#127822; 느낀점

DP가 Down-Top 방식이란 것을 확실히 보여주는 문제였다.
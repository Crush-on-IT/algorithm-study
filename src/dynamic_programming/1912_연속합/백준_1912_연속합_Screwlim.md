# 백준1912\_연속합

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
sum_max = [0 for _ in range(N)]
Max = -1001
for i in range(1, N):
    sum_max[i] = max(sum_max[i-1] + nums[i], nums[i])
    Max = max(Max, sum_max[i])

print(Max)
```

### &#127822; 풀이 방법

연속된 수열의 합 중 최대를 찾는다.

1. 각 수열의 원소마다 이전까지의 합을 고려해 최대합을 구할 수 있다.

2. 음수가 있기에 합이 오히려 이전까지의 합보다 감소하는 경우가 있다. 이를 위해 Max값을 따로 기록한다.

3. 연속된 수열의 합이기에 음수 이후, 새로 연속된 수열의 합을 가져야하는 경우가 생긴다.(음수가 이때까지 연속된 수열합보다 절대값이 큰 경우) 이를 위해 각 연속합은 현재값과 이전연속값의 함 + 현재값을 비교하여 더 큰 값을 넣어준다.

위 설명을 위한 쉬운 그림 설명

![1912_graph](/contents/img/BJ1912_Screwlim.jpeg)

### &#127822; 느낀점
음수가 있어 이에대한 예외처리를 하려고 했으나, 역시 sub problem의 해에서 예외는 없다.
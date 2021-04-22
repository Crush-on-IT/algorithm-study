# 백준2110\_공유기 설치

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys

N, C = map(int, sys.stdin.readline().rstrip().split())
houses = [int(sys.stdin.readline()) for _ in range(N)]
houses.sort()

min = 1
max = houses[N-1] - houses[0]
ans = 1

while min <= max:
    pivot = (min + max) // 2
    installed = 1
    before_house = houses[0]
    for house in houses:
        if pivot <= house - before_house:
            installed += 1
            before_house = house
    if installed >= C:
        ans = pivot
        min = pivot + 1
    else:
        max = pivot - 1

print(ans)
```

### &#127822; 풀이 방법

정해진 공유기 수를 최대한 거리가 공평하게 배분하는 문제이다. 

공유기 간의 거리를 매개변수로 두고 이진 탐색으로 적절한 값을 찾는다.

1. 입력값을 받고 각 집의 데이터를 sort한다.

2. min은 1로, max는 첫번째 집과 마지막 집 사이의 거리로 둔다.

3. pivot값으로 주어진 거리를 활용해, 각 집을 순회하며 설치한다.

4. 설치된 집의 수가 공유기의 수보다 부족하면 거리를 줄이고, 많으면 거리를 늘린다.

5. 적절한 거리를 구할 때 까지 반복한다.

### &#127822; 느낀점


# 백준13305\_주유소

### &#127822; 분류

Greedy

### &#127822; 코드

```python
import sys

V = int(sys.stdin.readline().rstrip())
roads = list(map(int, sys.stdin.readline().split()))
oils = list(map(int, sys.stdin.readline().split()))

here_oil = int(1e10)
here = 0
cost = 0
for i in range(len(oils)):
    if here_oil > oils[i]:
        for j in range(here, i):
            cost += roads[j] * here_oil
        here = i
        here_oil = oils[i]

for i in range(here, len(oils)-1):
    cost += roads[i] * here_oil

print(cost)
```

### &#127822; 풀이 방법

Greedy 문제들은 매번 최선의 해를 선택했을 때 최종적으로도 최적의 해를 얻을 수 있다는 원리를 기반으로 한다.

각 주유소를 방문할 때 기름의 가격이 이전보다 비싸면 이전 값으로, 아니면 새로운 가격으로 기름을 사서 이동한다.

1. road, oils에 각각 입력받은 값을 저장한다.

2. oils를 순회하며 각 방문마다 현재 저장된 기름값과 비교하면서 더 싼 값을 찾는다.

3. 더 싼 값을 찾은 경우 이전 주유소까지 그 전에 저장되어 있던 기름값으로 이동한만큼 cost를 더한다. 이때 here에 현재 지점을 저장하여 다음 계산때 계산의 시작점이 되도록 한다.

4. 마지막에 다다랐을때는 기름값이 더 싸지 않더라도 cost를 계산한다.

### &#127822; 느낀점

손에 잘 안잡히는구만 ㅎ
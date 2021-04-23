# 백준1939\_중량제한

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
bridges = [[] for _ in range(N+1)]
left = 0
right = 0

for _ in range(M):
    a, b, weight = map(int, sys.stdin.readline().rstrip().split())
    bridges[a].append((b, weight))
    bridges[b].append((a, weight))
    right = max(right, weight)

factorys = list(map(int, sys.stdin.readline().rstrip().split()))


def try_route_bfs(carry):
    stack = deque()
    stack.append(factorys[0])
    visited = set()
    visited.add(factorys[0])
    while stack:
        now = stack.popleft()
        for i, w in bridges[now]:
            if i not in visited:
                if w >= carry:
                    visited.add(i)
                    stack.append(i)
                    if i == factorys[1]:
                        return True
    return False


while left <= right:
    pivot = (left + right) // 2
    if try_route_bfs(pivot):
        ans = pivot
        left = pivot + 1
    else:
        right = pivot - 1

print(ans)
```

### &#127822; 풀이 방법

bfs와 이진 탐색이 혼합된 문제이다.

시작지점부터 목표지점까지의 길은 매번 트럭에 싣는 무게가 다르기 때문에 매번 새로 탐색해야한다. 따라서 이는 bfs로 찾게 된다.

매번 bfs로 길을 찾으며 해당 무게가 가능한지 불가능한지 확인하게 된다.

이를 토대로 적절한 무게를 이진 탐색으로 찾게된다.

1. 트럭에 싣는 무게는 최소 = 0, 최대는 다리들의 최대 하중

2. 중간값(pivot)설정 후 해당 값으로 bfs 검사

3. bfs로 목적지까지 도달하면 무게를 늘이는 방향으로, bfs로 목적지에 도달하지 못하면 무게를 줄이는 방향으로 범위 설정

4. 적절한 거리를 구할 때 까지 반복한다.

### &#127822; 느낀점

로직은 금방 구상했지만 구현하는데 사소한 실수들이 조금 있어 시간이 걸렸다.

또한 인접행렬로 구현할 시 메모리초과가 되어 완전한 인접행렬이 아닌, 다리가 있는 경우만 데이터를 생성하여 메모리를 줄였다. 인접 리스트로 구현해도 될듯하다.

이 문제는 kruskal algorithm으로도 해결할 수 있어 보인다.

추후에 다른 풀이로 시도 해봐야겠다.

# 백준1238\_파티

### &#127822; 분류

Shortest Path, Dijkstra

### &#127822; 코드

```python
import heapq
import sys

INF = int(1e9)

V, E, Party_V = map(int, sys.stdin.readline().split())

graph = [[]for i in range(V+1)]
graph_inv = [[]for i in range(V+1)]

distanceFrom = [INF] *(V+1)
distanceTo = [INF] *(V+1)

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((d_node, weight))
    graph_inv[d_node].append((s_node, weight))


def dijkstraFrom(start):
    global graph, distanceFrom
    q = []
    heapq.heappush(q, (0, start))
    distanceFrom[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distanceFrom[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            continue
        for i in graph_inv[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distanceFrom[i[0]]:
                distanceFrom[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


def dijkstraTo(start):
    global graph_inv, distanceTo
    q = []
    heapq.heappush(q, (0, start))
    distanceTo[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distanceTo[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            continue
        for i in graph[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distanceTo[i[0]]:
                distanceTo[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkstraFrom(Party_V)
dijkstraTo(Party_V)
ans = 0
for i in range(V+1):
    if distanceFrom[i] == INF or distanceTo[i] == INF:
        continue
    temp = distanceTo[i] + distanceFrom[i]
    ans = max(temp, ans)

print(ans)
```

### &#127822; 풀이 방법

Dijkstra 문제이다. 단, inverse graph를 고려해야한다.

1. 파티가 진행되는 노드를 시작점이라고 생각한다.

2. 시작점에서 가는 방향으로 다익스트라를 진행한다. (dijkstraFrom)

3. 시작점으로 오는 방향으로 다익스트라를 진행한다. (dijkstraTo)

4. 각 진행한 결과를 합치며 최대값을 찾는다.

5. 찾은 값을 출력한다.

### &#127822; 느낀점

inverse graph를 입력 받을때, 반대 로직으로 단순히 입력했지만, 인접행렬로 하면 메모리 중복없이 구현할 수 있을 것 같다.

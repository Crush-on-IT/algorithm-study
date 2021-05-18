# 백준1753\_최단경로

### &#127822; 분류

Shortest Path, Dijkstra

### &#127822; 코드

```python
import heapq
import sys

INF = int(1e9)

V, E = map(int, sys.stdin.readline().split())
start_node = int(sys.stdin.readline())

graph = [[]for i in range(V+1)]
distance = [INF] *(V+1)

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((d_node, weight))


def dijkstra(start):
    global graph, distance
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        print(q)
        dist, now = heapq.heappop(q)
        if distance[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            print("hey!", end="  ")
            print(distance[now], dist)
            continue
        for i in graph[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                print(cost, i[0])
                heapq.heappush(q, (cost, i[0]))


dijkstra(start_node)
for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
```

### &#127822; 풀이 방법

Dijkstra 예제이다.

모든 지점에 대해서 출발점에서부터 최단거리를 계산한다.

bfs와 DP가 합쳐진 느낌이다.

1. 주어진 시작점부터 시작한다.

2. q에서 다음 탐색할 노드를 꺼내온다.

3. 지정된 노드에 대해 저장된 최단거리의 값 vs 이전에 최단거리로 계산된 값을 비교하여 만약 이미 저장된 값이 더 낮을 경우, 이미 해당 지점에 대해 최단거리가 다시 계산되었으므로 다익스트라를 진행하지 않는다.

4. 인접한 노드에 대해 다익스트라를 진행한다.

5. 새로 계산된 값이 더 효율적인 경우, 해당 값을 저장하고 q에 넣는다.

6. q가 빌때까지 반복한다.(즉, 더 이상 효율적인 경로로 탐색할 노드가 없다는 뜻)

### &#127822; 느낀점

처음 구현할 때 이해가 잘 안되서 다른 예제 풀이를 참고했다.

Dijkstra 다른 케이스도 풀어보고 확실히 이해해야겠다.
# 백준16398\_행성 연결

### &#127822; 분류

MST, Prim

### &#127822; 코드

```python
import sys
import heapq

V = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for i in range(1, V+1):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, V+1):
        if i == j: continue
        graph[i].append((temp[j-1], i, j))


def prim():

    global graph
    cost = 0
    edge_count = 0
    q = []
    for i in graph[1]:
        heapq.heappush(q, i)
    visited[1] = True

    while q:
        weight, s_node, d_node = heapq.heappop(q)
        if visited[d_node]:
            continue
        else:
            cost += weight
            edge_count += 1
            visited[d_node] = True
            for i in graph[d_node]:
                heapq.heappush(q, i)
        if edge_count == V-1:
            return cost
    return cost


print(prim())
```

### &#127822; 풀이 방법

각 간선에 대한 정보가 인접배열로 주어진다.

Prim으로 풀기 위해서 이를 다시 각 node별로 연결된 간선 정보를 weight와 같이 다시 저장했다.

그 뒤 Prim 알고리즘은 동일

### &#127822; 느낀점

Prim으로 풀려면 각 노드별로 연결된 간선 정보를 찾기 쉽고, 우선순위 큐를 활용해 연결된 간선들 중 최소값을 바로 얻을 수 있어야 함.
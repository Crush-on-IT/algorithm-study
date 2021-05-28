# 백준1368\_물대기

### &#127822; 분류

MST, Prim

### &#127822; 코드

```python
import sys
import heapq

V = int(sys.stdin.readline().rstrip())
make_well = [0]
for _ in range(V):
    make_well.append(int(sys.stdin.readline().rstrip()))
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for i in range(1, V+1):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, V+1):
        if i == j: continue
        graph[i].append((temp[j-1], i, j))


def prim():
    global graph, make_well
    cost = 0
    edge_count = 0
    q = []

    for i in range(1, V+1):
        heapq.heappush(q, (make_well[i], i, i))

    while q:
        weight, s_node, d_node = heapq.heappop(q)
        if visited[d_node]:
            continue
        cost += weight
        edge_count += 1
        visited[d_node] = True
        for i in graph[d_node]:
            heapq.heappush(q, i)

        if edge_count == V:
            return cost
    return cost


print(prim())

```

### &#127822; 풀이 방법

문제를 해석하면 자기자신에게 스스로 돌아가는 간선이 하나씩 추가된 그래프이다.

따라서 시작점을 임의로 주는 것이 아니라, 시작점을 주지 않고, 각자 스스로에게 돌아가는 간선들을 우선순위 큐에 넣는다.

그 후엔 동일하게 Prim알고리즘을 사용하고, 이 경우, 어느 시작점이든 처음 시작할 때는 자신에게 스스로 돌아가는 간선을 하나 사용한 후 MST를 구성하는 것이니 총 선택된 간선의 수가 노드의 수와 일치해야한다.

### &#127822; 느낀점

변형문제라고 각 알고리즘의 구성요소를 제대로 이해하면 많이 어렵진 않다.
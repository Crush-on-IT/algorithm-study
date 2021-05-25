# 백준1197\_최소 스패닝 트리

### &#127822; 분류

MST, Prim

### &#127822; 코드

```python
import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((weight, s_node, d_node))
    graph[d_node].append((weight, d_node, s_node))
# 가중치 순으로 간선 정렬
for i in range(1, V+1):
    graph[i].sort(key=lambda x: x[1])


def prim():
    global graph
    cost = 0
    edge_count = 0
    q =[]
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


print(prim())

```

### &#127822; 풀이 방법

동일한 MST문제를 Prim알고리즘으로 풀이함

1. 이 문제에서 간선은 양방향이기에 입력받고 graph에 양쪽 node모두에 간선정보를 저장한다.

2. 각 노드별로 간선을 weight 기준으로 정렬한다.

3. 처음 시작 노드에 연결된 간선의 정보를 Heap Queue에 넣는다. (weight별로 정렬되도록 하기 위함.)

4. q가 빌때까지/ 간선의 수가 V-1개가 될때까지 아래를 반복한다.

    q에 담긴 간선중 가장 weight가 적은 값을 검사한다.

    해당 간선으로 갈 수 있는 node가 이미 방문한 곳인지 확인한다.

    하지 않았을 경우 visit한다.

    한 경우, pass한다.

5. Prim함수가 종료되면 누적된 weight값을 출력한다.

### &#127822; 느낀점

Prim은 Dijkstra, Kruskal은 Bellman-Ford느낌이다.
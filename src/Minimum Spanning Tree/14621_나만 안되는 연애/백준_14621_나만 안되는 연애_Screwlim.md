# 백준14621\_나만 안되는 연애

### &#127822; 분류

MST, Prim

### &#127822; 코드

```python
import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
uni_gender = sys.stdin.readline().split()
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    if uni_gender[s_node-1] == uni_gender[d_node-1]: continue
    graph[s_node].append((weight, s_node, d_node))
    graph[d_node].append((weight, d_node, s_node))


def prim():

    global graph
    cost = 0
    edge_count = 0
    q = []
    for i in graph[1]:
        heapq.heappush(q, i)
    visited[0] = visited[1] = True

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


answer = prim()

if False in visited:
    print(-1)
else:
    print(answer)
```

### &#127822; 풀이 방법

문제를 해석하면 그래프의 각 노드가 두가지로 종류가 나열되어 MST를 구성할 때는 같은 종류의 노드가 연결된 간선은 사용하면 안된다.

간선 정보를 입력받을 때 단순히 같은 종류의 노드끼리 연결되어있는 경우, 무시하면 된다.

그 후 저장된 graph의 정보에 대해서 MST를 만들면 된다. 나의 경우 Prim을 사용했다.

마지막으로 이렇게 몇몇 간선을 무시하면 MST가 생성되지 못하는 경우가 생기는데, 즉 방문되지 못하는 노드가 발생할 수 있다.

따라서 방문 여부를 확인하는 배열 visited를 확인하여 방문하지 않은 노드가 하나라도 있으면 -1을 아니면 계산된 값을 출력하면 된다.

### &#127822; 느낀점

문제이름 킹받네
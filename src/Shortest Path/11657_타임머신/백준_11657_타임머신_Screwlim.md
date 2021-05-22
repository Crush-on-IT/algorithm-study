# 백준11403\_경로 찾기

### &#127822; 분류

Shortest Path, Bellman-Ford

### &#127822; 코드

```python
import sys


def bellmanFord():
    global isPossible

    for repeat in range(N):
        for i in range(1, N + 1):
            for wei, vec in graph[i]:
                if distance[i] != INF and distance[vec] > distance[i] + wei:
                    distance[vec] = distance[i] + wei
                    if repeat == N - 1:
                        isPossible = False


N, E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]
INF = int(1e9)
distance = [INF] * (N + 1)
distance[1] = 0
isPossible = True

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((weight, d_node))

bellmanFord()

if not isPossible:
    print(-1)
else:
    for d in distance[2:]:
        print(d if d != INF else -1)
```

### &#127822; 풀이 방법

Bellman Ford 예제이다.

Dijkstra와 비슷한 원리이지만, 노드를 보지않고, edge를 본다는 점이 차이점이다. 음의 사이클을 막기위해 각 노드개수 이상으로 탐색하는 경우를 확인하여 막는다.(사이클을 제외하면 나올 수 있는 노드의 방문수는 N-1이다.)

1. 시작노드의 거리 비용은 0으로 초기화 한다.

2. 노드의 개수만큼 방문(edge를 확인하는 것)을 반복한다.

3. 저장된 값과 비교하여 더 짧은 최단거리를 얻은 경우, 값을 갱신해준다.

4. 마지막 순회를 할 때, 또 다시 방문할 시 N번째 반복이면 음의 사이클이 생긴 경우라 판단하고 isPossible값을 False처리한다.

5. distance에 저장된 각 최단거리를 출력한다.

### &#127822; 느낀점

음의 사이클을 edge검사로 확인하는 bellman ford 알고리즘 예제이다.

정석 예제를 풀이했으니, 변형도 풀어봐야겠다.
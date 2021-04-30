# 백준10971\_외판원 순회 2

### &#127822; 분류

Backtracking, BFS

### &#127822; 코드

```python
import sys


def travel(depth, start, now, cost):
    global Map, min_cost, visited
    # 유망하지 않기에 제
    if cost >= min_cost:
        return

    if depth == N and Map[now][start] != 0:
        temp = cost + Map[now][start]
        min_cost = min(min_cost, temp)
        return

    for i in range(N):
        if not Map[now][i] == 0 and not visited[i]:외
            visited[i] = True
            if start == -1:
                travel(depth+1, i, i, 0)
            else:
                travel(depth+1, start, i, cost+Map[now][i])
            visited[i] = False


N = int(sys.stdin.readline().rstrip())
Map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [False] * N
min_cost = float('inf')
travel(0, -1, 0, 0)
print(min_cost)
```

### &#127822; 풀이 방법

순회하며 최소 비용을 저장해두고,

한 단계별로 순회할 때 마다, 최소 비용보다 커지면 유망성이 없다고 판단하여 더이상 순회하지 않는다.

1. dfs로 순회하되, visited를 기록하여 중복으로 순회하지 않는다.

2. N만큼 depth가 도달하면 모든 node를 탐색하였다는 말이므로, 출발지점으로 돌아간다.(가능할때만)

3. 순회를 마치면 min_cost에는 최소비용이 남게 된다.

### &#127822; 느낀점

backtracking하면 꼭 같이 제시되는 대표적인 예제이다.

순회를 진행하며 최솟값이 변하게 되고 이를 통해 유망성을 검사하게 된다.

마지막에 출발지로 돌아가는 길이 없을 경우 무효로 생각했어야 하는데 이부분을 놓쳐 애를 먹었다.

그것 말고는 무난했다.
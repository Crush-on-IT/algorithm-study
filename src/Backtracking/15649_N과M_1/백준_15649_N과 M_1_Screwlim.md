# 백준15649\_N과 M 1

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth):
    global N, M, visited, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            buffer.append(i+1)
            dfs(depth+1)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
visited = [False] * N
buffer = []
dfs(0)
```

### &#127822; 풀이 방법

Backtracking문제이다.

1부터 N까지의 node가 순차적으로, 재귀적으로 존재하는 tree가 있다고 가정하고, 

이미 전에 방문했던 node는 후에는 유망하지 않다고 판단하고 탐색하지 않는다.

각 node를 탐색할 때, 유망하지 않은 node들의 상태유지를 위해 bfs가 아닌 dfs로 탐색해야한다. 

1. 탐색은 1부터 시작한다.

2. 초기 depth는 0이다.
    
3. 각 node를 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장한다.

5. 탐색이 마친경우 buffer에서 제거하고, visited도 초기화 한다.

6. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

처음 문제를 보았을 때 python의 itertools의 permutation이 생각났지만 backtracking의 이론대로 문제풀이를 하였다.

이론대로 로직을 짜는 연습을 하는게 추후의 응용문제에서 사고력에 도움이 되는 것 같다.
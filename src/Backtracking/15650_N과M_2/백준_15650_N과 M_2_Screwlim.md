# 백준15650\_N과 M 2

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth, index):
    global N, M, visited, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(index, N):
        if not visited[i]:
            visited[i] = True
            buffer.append(i+1)
            dfs(depth+1, i+1)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
visited = [False] * N
buffer = []
dfs(0, 0)
```

### &#127822; 풀이 방법

N과 M시리즈 2

1번 문제의 조건에 하나가 더 추가된 문제이다.

출력하는 순열은 오름차순을 따라야한다.

즉 유망성 검사에서 현재 값보다 작은 값은 유망하지 않다고 판단하여 제외하면 된다.

1. 탐색은 1부터 시작한다.

2. 초기 depth는 0이다.
    
3. 각 node중 현재 index보다 큰 수부터 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장한다.

5. 탐색이 마친경우 buffer에서 제거하고, visited도 초기화 한다.

6. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

1번 문제가 permutation이였다면 2번은 combination이였다.

단순히 현재 index의 값을 조회하여 유망성 검사에 추가하였더니 풀렸다.
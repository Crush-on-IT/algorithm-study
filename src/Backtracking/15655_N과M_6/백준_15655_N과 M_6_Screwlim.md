# 백준15655\_N과 M 6

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth, index):
    global N, M, buffer, visited

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(index, N):
        if not visited[i]:
            visited[i] = True
            buffer.append(lists[i])
            dfs(depth+1, i)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
lists = list(map(int, sys.stdin.readline().split()))
lists.sort()
visited = [False] * N
buffer = []
dfs(0, 0)

```

### &#127822; 풀이 방법

N과 M시리즈 6

2번 문제에서 순열이 입력된 순열로 상황이 바뀐 문제이다.

입력받고 sort한 후, 동작하는 로직은 동일하다.

1. 탐색은 1부터 시작한다.

2. 초기 depth는 0이다.
    
3. 각 node중 현재 index번째 값보다 큰 수부터 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장한다.

5. 탐색이 마친경우 buffer에서 제거하고, visited도 초기화 한다.

6. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

입력받는 값이 변하더라도 현재 문제에서는 sort만 해주면 1~N까지 수열이나, 임의의 값들로 이루어진 수열이나 결과는 동일하다.
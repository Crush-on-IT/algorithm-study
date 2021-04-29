# 백준15654\_N과 M 5

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth):
    global N, M, buffer, visited

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            buffer.append(lists[i])
            dfs(depth+1)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
lists = list(map(int, sys.stdin.readline().split()))
lists.sort()
visited = [False] * N
buffer = []
dfs(0)

```

### &#127822; 풀이 방법

N과 M시리즈 5

1번 문제에서 상황이 하나 바뀐 문제이다.

1~N까지 자연수로 이루어져 있던 순열이 이제 입력되는 순열이 될 뿐이다.

입력받고 sort한 후, 동작하는 로직은 동일하다.

즉, 조합순열에서 현재 값보다 작은 값을 조회하는 것은 유망성이 없다고 판단하여 제외하면 된다.

1. 탐색은 1부터 시작한다.

2. 초기 depth는 0이다.
    
3. 각 node를 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장하며 visited를 True로 변경시킨다.

5. 탐색이 마친경우 buffer에서 제거하고, visited도 초기화 한다.

6. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

입력받는 값이 변하더라도 현재 문제에서는 sort만 해주면 1~N까지 수열이나, 임의의 값들로 이루어진 수열이나 결과는 동일하다.
# 백준15652\_N과 M 4

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth, index):
    global N, M, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(index-1, N):
        buffer.append(i+1)
        dfs(depth+1, i+1)
        buffer.pop()


N, M = map(int, sys.stdin.readline().split())
buffer = []
dfs(0, 1)

```

### &#127822; 풀이 방법

N과 M시리즈 4

3번 문제의 조건이 하나 추가된 문제이다.

출력하는 수열은 비내림차순을 따라야 한다.

즉, 조합순열에서 현재 값보다 작은 값을 조회하는 것은 유망성이 없다고 판단하여 제외하면 된다.

1. 탐색은 1부터 시작한다.

2. 초기 depth는 0이다.
    
3. 각 node를 현재값보다 큰 값들부터 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장한다.

5. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

비오름차순을 위해서는 현재 값을 확인해야하므로 index parameter를 추가하여 해결했다.
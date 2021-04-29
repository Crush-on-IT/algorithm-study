# 백준15651\_N과 M 3

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(depth):
    global N, M, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        buffer.append(i+1)
        dfs(depth+1)
        buffer.pop()


N, M = map(int, sys.stdin.readline().split())
buffer = []
dfs(0)

```

### &#127822; 풀이 방법

N과 M시리즈 3

2번 문제의 조건이 하나 바뀐 문제이다.

출력하는 수열은 중복이 허용되는 조합순열이다.

즉 1,2번에서 유망성 검사에서 제외시키는 과정을 제거하면 된다.

1. 탐색은 1부터 N까지 진행된다.

2. 초기 depth는 0이다.
    
3. 각 node를 순회하며 depth를 1 증가시킨다.

4. 탐색한 node는 buffer에 저장한다.

5. depth가 M과 일치할 경우, buffer의 값을 출력한다.

### &#127822; 느낀점

중복을 허용하기 위해서는 visited와 오름차순을 지키기위해 추가한 index를 삭제해야 했다.

순회가 1부터 N순으로 진행되기에 사전순서대로 출력하는 것은 알아서 처리된다.
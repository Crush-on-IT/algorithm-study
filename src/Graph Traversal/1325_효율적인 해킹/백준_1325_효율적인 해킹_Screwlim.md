# 백준14940\_효율적인 해킹

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())

comp = [[] for _ in range(n+1)]

can_heck = [0 for _ in range(n+1)]
ans = []
for _ in range(m):
    start, dest = map(int, input().split())
    comp[dest].append(start)


def bfs(com):
    visited = [False] * (n+1)
    visited[com] = True
    stack = deque()
    stack.append(com)
    while stack:
        node = stack.popleft()
        for i in comp[node]:
            if visited[i] == 0:
                stack.append(i)
                visited[i] = True
                can_heck[com] += 1


for k in range(1, n+1):
    bfs(k)

mx = 0
for i in range(1, n + 1):
    temp = can_heck[i]
    if mx <= temp:
        if mx < temp:
            ans = []
        mx = temp
        ans.append(i)

print(*ans)
```

### &#127822; 풀이 방법

신뢰하고 있는 컴퓨터들을 역으로 해킹할 수 있는 컴퓨터라고 생각하면 단방향 그래프가 생성된다.

1. 주어진 데이터를 읽고 해당 Tree(comp)를 생성한다. (이중 배열이지만, 메모리 문제로 신뢰하고 있는 컴퓨터의 번호만 가지도록 함)

2. 1~N까지 순회하면서 bfs실행

3. 각 bfs시 처음 해킹하는 컴퓨터마다 count 1증가

4. 각 컴퓨터당 해킹한 컴퓨터수가 저장된 can_heck배열에서 최댓값 조회 및 해당 컴퓨터 출력

### &#127822; 느낀점

이제 bfs, dfs구현은 어렵지 않으나 어려운 문제일 수록 조건이 하나 더 추가되거나, 시간조건, 메모리 제한이 빡빡해지는것 같다.

처음 구현했을때 예시는 정상출력했으나, 메모리 초과로 틀렸었다.

이에 평소의 인접행렬과 다르게 필요한 인덱스만 저장하도록 하였고, 

그 다음으로는 계속 시간초과가 발생해서 input을 조정하거나 최댓값 출력 부분을 최소화 하였지만....

python3 말고 pypy3로 했더니 되더라...ㅜ

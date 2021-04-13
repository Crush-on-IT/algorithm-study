# 백준2606\_바이러스

### &#127822; 분류

Graph traversal, DFS

### &#127822; 코드

```python
import sys
from collections import deque

n = int(sys.stdin.readline())
v = int(sys.stdin.readline())

infected = [0 for _ in range(n+1)]
#graph 생성
networks = [[0 for _ in range(n+1)] for _ in range(n+1)]
# vertex 생성
for _ in range(v):
    fromNode, toNode = map(int, sys.stdin.readline().rstrip().split(" "))
    networks[fromNode][toNode] = 1
    networks[toNode][fromNode] = 1

def worm(com):
    infected[com] = 1
    for i in range(1, n+1):
        if infected[i] == 0 and networks[com][i] == 1:
            worm(i)

worm(1)

print(sum(infected)-1)
```

### &#127822; 풀이 방법

1. 주어진 데이터를 읽고 해당 Tree를 생성한다. (이중 배열로 구현)

2. vertex의 여부를 따라 각 node를 순회한다.

3. dfs의 경우, node의 번호가 작은 순서대로 재귀함수로 먼저 호출하여 순회

4. bfs의 경우, 해당 node와 연결된 node를 모두 stack에 저장하며 stack 순서대로 다시 순회한다.

### &#127822; 느낀점

오랜만의 bfs, dfs다. tree를 구현하는데 여러가지 방법으로 시도해봐야겠다. 우선 가장쉬운 이중배열로 구현했는데 통과는 했지만 linked list로 구현하면 좀 더 시간을 줄일 수 있지 않을까.
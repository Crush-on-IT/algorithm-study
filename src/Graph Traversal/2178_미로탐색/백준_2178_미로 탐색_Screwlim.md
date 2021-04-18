# 백준2178\_미로 탐색

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque

y, x = map(int, sys.stdin.readline().split())

stack = deque()
map = [[] for _ in range(y)]
for k in range(y):
    temp = sys.stdin.readline().rstrip()
    for i in temp:
        map[k].append(int(i))

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
ans = 0

stack.append([0, 0])

while stack:
    now = stack.popleft()
    if map[now[0]][now[1]] > ans:
        ans = map[now[0]][now[1]]
    for i in range(4):
        now_x = now[1] + move_x[i]
        now_y = now[0] + move_y[i]
        if 0 <= now_x < x and 0 <= now_y < y:
            if map[now_y][now_x] == 1:
                stack.append([now_y, now_x])
                map[now_y][now_x] = map[now[0]][now[1]] + 1


print(map[y-1][x-1])
```

### &#127822; 풀이 방법

1. map을 인접 배열로 생성

2. 4방향을 확인하며 bfs로 탐색

3. 마지막 목적지에 저장된 값 출력

### &#127822; 느낀점

매우 전형적인 bfs문제. 목적지와 출발지가 정해져 있어서 간단히 해결

# 백준14940\_쉬운 최단거리

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque

y, x = map(int, sys.stdin.readline().split())

stack = deque()
#tree 생성
Map = [list(map(int,sys.stdin.readline().split())) for _ in range(y)]

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
step = 0
ans = ""
temp = ""

for i in range(y):
    for k in range(x):
        if Map[i][k] == 2:
            Goal = [i, k]
            stack.append(Goal)
            # Map[i][k] = 0
            break

while stack:
    now = stack.popleft()
    for i in range(4):
        now_x = now[1] + move_x[i]
        now_y = now[0] + move_y[i]
        if 0 <= now_x < x and 0 <= now_y < y:
            if Map[now_y][now_x] == 1:
                stack.append([now_y, now_x])
                Map[now_y][now_x] = Map[now[0]][now[1]] + 1

for k in range(y):
    for i in range(x):
        if Map[k][i] > 0:
            Map[k][i] -= 2
        print(Map[k][i], end=" ")
    print()
```

### &#127822; 풀이 방법

지도의 모든 지점에서 목적지까지의 최단거리를 구한다.

역으로 생각하여 목적지에서 다른 모든 지점까지의 걸음수를 저장하면 된다.

즉, 순회하면서 바로 전 지점까지의 걸음수에 하나씩 증가시켜 저장하면 된다.

1. 주어진 데이터를 읽고 해당 Tree(Map)를 생성한다. (이중 배열로 구현)

2. 시작점을 stack에 넣는다.

3. stack에 있는 값들을 차례로 순회(bfs)한다.

4. 순회하며 순회하기 한 단계 전의 좌표값(지난 시간을 의미)에 1씩 증가하며 값을 넣어준다.

5. 시작점은 초기에 2로 표기되었으므로 0으로 고쳐주고 전체 Map을 출력한다.

### &#127822; 느낀점

처음에는 몰랐는데 구현하다보니 이전에 풀었던 토마토와 동일한 원리로 풀 수 있었다.

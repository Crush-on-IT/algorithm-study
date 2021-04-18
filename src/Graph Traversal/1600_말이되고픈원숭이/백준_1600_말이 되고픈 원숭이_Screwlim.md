# 백준1600\_말이 되고픈 원숭이

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque
input = sys.stdin.readline

k = int(input())
w, h = map(int, input().split())

map = [list(map(int, input().split())) for _ in range(h)]
visited = [[[0 for _ in range(k+1)] for _ in range(w)]for _ in range(h)]
# 모든 이동들을 말 움직임 횟수와 좌표로 구분하여 step수를 독립적으로 저장
stack = deque()

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]

hmove_x = [2, 1, 2, -1, -2, -2, -1, 1]
hmove_y = [1, 2, -1, 2, -1, 1, -2, -2]
# 시작점과 도착점이 정해져있기 때문에 그 방향에 어긋나는 이동은 제외

def bfs():
    while stack:
        y, x ,h_num = stack.popleft()
        if x == w-1 and y == h-1:
            return visited[y][x][h_num]
        for i in range(4):
            now_x = x + move_x[i]
            now_y = y + move_y[i]
            if 0 <= now_x < w and 0 <= now_y < h and visited[now_y][now_x][h_num] == 0:
                if map[now_y][now_x] != 1:
                    stack.append([now_y, now_x, h_num])
                    visited[now_y][now_x][h_num] = visited[y][x][h_num]+1
        # horse move가 아직 가능한 케이스 / horse move를 모두 사용한 케이스는 스킵
        if h_num < k:
            for i in range(8):
                now_x = x + hmove_x[i]
                now_y = y + hmove_y[i]
                if 0 <= now_x < w and 0 <= now_y < h and visited[now_y][now_x][h_num+1] == 0:
                    if map[now_y][now_x] != 1:
                        stack.append([now_y, now_x, h_num+1])
                        visited[now_y][now_x][h_num+1] = visited[y][x][h_num] + 1
    return -1


stack.append([0, 0, 0])
print(bfs())
```

### &#127822; 풀이 방법

최단거리 문제에서 변형이 들어간 문제였다.

핵심은 움직이는 방식이 두가지(말, 일반)이며, 말 움직임은 횟수제한이 있는 것이다.

알파고가 바둑을 분기하는 그래프에서 아이디어를 얻고 풀이했다.

1. 주어진 데이터를 읽고 해당 map과 visited를 생성한다. (이중 배열로 구현)

2. map은 해당 좌표로 이동이 가능한지 여부를 확인하는 용 / visited는 같은 좌표에 도달하더라도 말 이동의 횟수에 따라 구분하여 step수를 저장하는 것.

3. bfs순회시, 말 움직임 횟수를 확인하며 진행.

4. 최종 지점에 도달할 시 저장된 step 출력

### &#127822; 느낀점

이동 방법이 두가지이기에 생기는 경우의 수를 따질때, 순서는 중요하지 않다고 생각하고 로직을 짜서 헛고생을 조금 했다.

조금씩 bfs, dfs 이해도가 늘어가는 느낌이다.
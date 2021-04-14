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
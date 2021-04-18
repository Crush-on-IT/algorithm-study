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
import sys
from collections import deque

x, y = map(int, sys.stdin.readline().split())
stack = deque()
#tree 생성
box=[list(map(int,sys.stdin.readline().split())) for _ in range(y)]

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
ans = 0

for i in range(y):
    for k in range(x):
        if box[i][k] == 1:
            stack.append([i, k])
print(stack)

while stack:
    now = stack.popleft()
    print(now)
    if box[now[0]][now[1]] > ans:
        ans = box[now[0]][now[1]]
    for i in range(4):
        now_x = now[1] + move_x[i]
        now_y = now[0] + move_y[i]
        if 0 <= now_x < x and 0 <= now_y < y:
            if box[now_y][now_x] == 0:
                stack.append([now_y, now_x])
                box[now_y][now_x] = box[now[0]][now[1]] + 1
                print("ripe here", end=" : ")
                print(now_y, now_x)

    for k in range(y):
        print(box[k])
    print("----------------------")


for k in range(y):
    for i in range(x):
        if box[k][i] == 0:
            ans = 0
print(ans-1)
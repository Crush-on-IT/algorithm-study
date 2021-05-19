import sys
from collections import deque

Y, X = map(int, sys.stdin.readline().split())

stack = deque()
#tree 생성
map_ = [list(map(int,sys.stdin.readline().split())) for _ in range(Y)]
dp = [[-1 for _ in range(X)] for _ in range(Y)]
move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]


def dfs(x, y):
    if x == X-1 and y == Y-1:
        return 1
    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0
    for i in range(4):
        nx = move_x[i] + x
        ny = move_y[i] + y
        if 0 <= nx < X and 0 <= ny < Y:
            if map_[ny][nx] < map_[y][x]:
                dp[y][x] += dfs(nx, ny)

    return dp[y][x]


dfs(0, 0)
print(dp[0][0])
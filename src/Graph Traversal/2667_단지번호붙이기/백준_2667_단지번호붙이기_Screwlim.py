import sys
from collections import deque

n = int(sys.stdin.readline())

map = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(n)]

stack = deque()

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
housenum = 1
nums = []

def bfs(node, housenum):
    houses = 1
    map[node[0]][node[1]] = housenum
    while stack:
        here = stack.popleft()
        for i in range(4):
            next_x = here[1] + move_x[i]
            next_y = here[0] + move_y[i]
            if 0 <= next_x < n and 0 <= next_y < n:
                if map[next_y][next_x] == 1:
                    houses += 1
                    map[next_y][next_x] = housenum
                    stack.append([next_y, next_x])
    nums.append(houses)
    for i in range(n):
        print(map[i])
    print("-------------------------------")


for i in range(n):
    for k in range(n):
        if map[i][k] == 1:
            stack.append([i, k])
            housenum += 1
            bfs([i, k], housenum)

nums.sort()
print(housenum - 1)
for i in nums:
    print(i)

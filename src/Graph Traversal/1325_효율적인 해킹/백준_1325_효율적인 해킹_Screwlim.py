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
import sys


def dfs(depth):
    global N, M, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        buffer.append(i+1)
        dfs(depth+1)
        buffer.pop()


N, M = map(int, sys.stdin.readline().split())
buffer = []
dfs(0)

import sys


def dfs(depth, index):
    global N, M, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(index-1, N):
        buffer.append(i+1)
        dfs(depth+1, i+1)
        buffer.pop()


N, M = map(int, sys.stdin.readline().split())
buffer = []
dfs(0, 1)

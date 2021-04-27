import sys


def dfs(depth):
    global N, M, visited, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            buffer.append(i+1)
            dfs(depth+1)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
visited = [False] * N
buffer = []
dfs(0)

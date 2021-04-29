import sys


def dfs(depth):
    global N, M, buffer, visited

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            buffer.append(lists[i])
            dfs(depth+1)
            visited[i] = False
            buffer.pop()


N, M = map(int, sys.stdin.readline().split())
lists = list(map(int, sys.stdin.readline().split()))
lists.sort()
visited = [False] * N
buffer = []
dfs(0)

import sys


def dfs(depth, index):
    global N, M, buffer

    if depth == M:
        print(" ".join(map(str, buffer)))
        return
    for i in range(index, N):
        buffer.append(lists[i])
        dfs(depth+1, i)
        buffer.pop()


N, M = map(int, sys.stdin.readline().split())
lists = list(map(int, sys.stdin.readline().split()))
lists.sort()
buffer = []
dfs(0, 0)
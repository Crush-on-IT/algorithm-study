import sys


def travel(depth, start, now, cost):
    global Map, min_cost, visited
    # 유망하지 않기에 제외
    if cost >= min_cost:
        return

    if depth == N and Map[now][start] != 0:
        temp = cost + Map[now][start]
        min_cost = min(min_cost, temp)
        return

    for i in range(N):
        if not Map[now][i] == 0 and not visited[i]:외
            visited[i] = True
            if start == -1:
                travel(depth+1, i, i, 0)
            else:
                travel(depth+1, start, i, cost+Map[now][i])
            visited[i] = False


N = int(sys.stdin.readline().rstrip())
Map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [False] * N
min_cost = float('inf')
travel(0, -1, 0, 0)
print(min_cost)
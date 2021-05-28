import sys
import heapq

V = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for i in range(1, V+1):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, V+1):
        if i == j: continue
        graph[i].append((temp[j-1], i, j))


def prim():

    global graph
    cost = 0
    edge_count = 0
    q = []
    for i in graph[1]:
        heapq.heappush(q, i)
    visited[1] = True

    while q:
        weight, s_node, d_node = heapq.heappop(q)
        if visited[d_node]:
            continue
        else:
            cost += weight
            edge_count += 1
            visited[d_node] = True
            for i in graph[d_node]:
                heapq.heappush(q, i)
        if edge_count == V-1:
            return cost
    return cost


print(prim())
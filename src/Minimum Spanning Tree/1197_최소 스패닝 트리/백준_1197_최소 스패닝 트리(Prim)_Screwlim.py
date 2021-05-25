import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((weight, s_node, d_node))
    graph[d_node].append((weight, d_node, s_node))
# 가중치 순으로 간선 정렬
for i in range(1, V+1):
    graph[i].sort(key=lambda x: x[1])


def prim():
    global graph
    cost = 0
    edge_count = 1
    q =[]
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
        if edge_count == V:
            return cost


print(prim())

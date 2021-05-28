import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
uni_gender = sys.stdin.readline().split()
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)
for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    if uni_gender[s_node-1] == uni_gender[d_node-1]: continue
    graph[s_node].append((weight, s_node, d_node))
    graph[d_node].append((weight, d_node, s_node))


def prim():

    global graph
    cost = 0
    edge_count = 0
    q = []
    for i in graph[1]:
        heapq.heappush(q, i)
    visited[0] = visited[1] = True

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


answer = prim()
if False in visited:
    print(-1)
else:
    print(answer)

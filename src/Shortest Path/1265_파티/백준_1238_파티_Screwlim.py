import heapq
import sys

INF = int(1e9)

V, E, Party_V = map(int, sys.stdin.readline().split())

graph = [[]for i in range(V+1)]
graph_inv = [[]for i in range(V+1)]

distanceFrom = [INF] *(V+1)
distanceTo = [INF] *(V+1)

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((d_node, weight))
    graph_inv[d_node].append((s_node, weight))


def dijkstraFrom(start):
    global graph, distanceFrom
    q = []
    heapq.heappush(q, (0, start))
    distanceFrom[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distanceFrom[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            continue
        for i in graph_inv[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distanceFrom[i[0]]:
                distanceFrom[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


def dijkstraTo(start):
    global graph_inv, distanceTo
    q = []
    heapq.heappush(q, (0, start))
    distanceTo[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distanceTo[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            continue
        for i in graph[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distanceTo[i[0]]:
                distanceTo[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkstraFrom(Party_V)
dijkstraTo(Party_V)
ans = 0
for i in range(V+1):
    if distanceFrom[i] == INF or distanceTo[i] == INF:
        continue
    temp = distanceTo[i] + distanceFrom[i]
    ans = max(temp, ans)

print(ans)
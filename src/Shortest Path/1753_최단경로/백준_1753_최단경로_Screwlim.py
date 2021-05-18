import heapq
import sys

INF = int(1e9)

V, E = map(int, sys.stdin.readline().split())
start_node = int(sys.stdin.readline())

graph = [[]for i in range(V+1)]
distance = [INF] *(V+1)

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((d_node, weight))


def dijkstra(start):
    global graph, distance
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        print(q)
        dist, now = heapq.heappop(q)
        if distance[now] < dist: #현재 저장된 최단거리 vs 이전에 저장된 최단거리
            print("hey!", end="  ")
            print(distance[now], dist)
            continue
        for i in graph[now]: #각 인접한 node의 거리 확인
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                print(cost, i[0])
                heapq.heappush(q, (cost, i[0]))


dijkstra(start_node)
for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
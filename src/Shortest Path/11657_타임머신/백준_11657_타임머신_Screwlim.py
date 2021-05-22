import sys


def bellmanFord():
    global isPossible

    for repeat in range(N):
        for i in range(1, N + 1):
            for wei, vec in graph[i]:
                if distance[i] != INF and distance[vec] > distance[i] + wei:
                    distance[vec] = distance[i] + wei
                    if repeat == N - 1:
                        isPossible = False


N, E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]
INF = int(1e9)
distance = [INF] * (N + 1)
distance[1] = 0
isPossible = True

for _ in range(E):
    s_node, d_node, weight = map(int, sys.stdin.readline().split())
    graph[s_node].append((weight, d_node))

bellmanFord()

if not isPossible:
    print(-1)
else:
    for d in distance[2:]:
        print(d if d != INF else -1)
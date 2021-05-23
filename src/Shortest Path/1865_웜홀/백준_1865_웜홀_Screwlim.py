import sys


def bellmanFord():
    global time_travel

    for repeat in range(1, city + 1):
        for i in range(1, city + 1):
            print(distance)
            for wei, vec in graph[i]:
                if distance[vec] > distance[i] + wei:
                    distance[vec] = distance[i] + wei
                    if repeat == city:
                        time_travel = True
                        return
                        print("minus cycle!") #음의 사이클 발생함


N = int(sys.stdin.readline().rstrip())
for _ in range(N):
    city, road, worm_hole = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(city + 1)]
    INF = int(1e9)
    distance = [INF] * (city + 1)
    time_travel = False

    for _ in range(road):
        s_node, d_node, weight = map(int, sys.stdin.readline().split())
        graph[s_node].append((weight, d_node))
        graph[d_node].append((weight, s_node))

    for _ in range(worm_hole):
        s_node, d_node, weight = map(int, sys.stdin.readline().split())
        graph[s_node].append((-weight, d_node))

    bellmanFord()

    if time_travel:
        print('YES')
    else:
        print('NO')

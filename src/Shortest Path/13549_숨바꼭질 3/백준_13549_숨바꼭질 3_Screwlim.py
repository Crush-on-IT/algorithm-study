import heapq
import sys

INF = int(1e9)

subin, sister = map(int, sys.stdin.readline().split())
distance = [INF] * 100001


def find_sister(start, end):

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[end] != INF:
            return
        if distance[now] < dist:
            continue

        dir = [[0, 2*now], [1, now - 1], [1, now + 1]]
        for i in dir:
            if i[1] < 0 or i[1] > 100000:
                continue
            cost = dist + i[0]
            if cost < distance[i[1]]:
                distance[i[1]] = cost
                heapq.heappush(q, (cost, i[1]))


find_sister(subin, sister)
print(distance[sister])
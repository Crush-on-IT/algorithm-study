import heapq
import sys

N = int(sys.stdin.readline().rstrip())

lectures = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
lectures.sort(key=lambda x: x[0])

classRoom = []
heapq.heappush(classRoom, lectures[0][1])
for i in range(1,N):
    if classRoom[0] > lectures[i][0]:
        heapq.heappush(classRoom, lectures[i][1])
    else:
        heapq.heappop(classRoom)
        heapq.heappush(classRoom, lectures[i][1])

print(len(classRoom))
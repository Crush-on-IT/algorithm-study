import sys
from collections import deque

n = int(sys.stdin.readline())
v = int(sys.stdin.readline())

infected = [0 for _ in range(n+1)]
#graph 생성
networks = [[0 for _ in range(n+1)] for _ in range(n+1)]
# vertex 생성
for _ in range(v):
    fromNode, toNode = map(int, sys.stdin.readline().rstrip().split(" "))
    networks[fromNode][toNode] = 1
    networks[toNode][fromNode] = 1

def worm(com):
    infected[com] = 1
    for i in range(1, n+1):
        if infected[i] == 0 and networks[com][i] == 1:
            worm(i)

worm(1)

print(sum(infected)-1)
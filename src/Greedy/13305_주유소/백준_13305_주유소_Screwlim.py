import sys

V = int(sys.stdin.readline().rstrip())
roads = list(map(int, sys.stdin.readline().split()))
oils = list(map(int, sys.stdin.readline().split()))

here_oil = int(1e10)
here = 0
cost = 0
for i in range(len(oils)):
    if here_oil > oils[i]:
        for j in range(here, i):
            cost += roads[j] * here_oil
        here = i
        here_oil = oils[i]

for i in range(here, len(oils)-1):
    cost += roads[i] * here_oil

print(cost)
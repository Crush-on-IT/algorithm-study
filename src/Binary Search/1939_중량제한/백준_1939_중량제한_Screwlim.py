import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
bridges = [[] for _ in range(N+1)]
left = 0
right = 0

for _ in range(M):
    a, b, weight = map(int, sys.stdin.readline().rstrip().split())
    bridges[a].append((b, weight))
    bridges[b].append((a, weight))
    right = max(right, weight)

factorys = list(map(int, sys.stdin.readline().rstrip().split()))


def try_route_bfs(carry):
    stack = deque()
    stack.append(factorys[0])
    visited = set()
    visited.add(factorys[0])
    while stack:
        now = stack.popleft()
        for i, w in bridges[now]:
            if i not in visited:
                if w >= carry:
                    visited.add(i)
                    stack.append(i)
                    if i == factorys[1]:
                        return True
    return False


while left <= right:
    pivot = (left + right) // 2
    if try_route_bfs(pivot):
        ans = pivot
        left = pivot + 1
    else:
        right = pivot - 1

print(ans)
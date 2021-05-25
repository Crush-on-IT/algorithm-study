import sys

V = int(sys.stdin.readline().rstrip())
E = int(sys.stdin.readline().rstrip())
edges = []

for _ in range(E):
    a, b, w = map(int, sys.stdin.readline().split())
    edges.append((w, a, b))
# 가중치 순으로 간선 정렬
edges.sort(key=lambda x: x[0])
parent = list(range(V + 1))


#간선 압축
def union(a, b):
    a = find(a)
    b = find(b)

    if b < a:
        parent[a] = b
    else:
        parent[b] = a


def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a]) # 경로 압축하는 과정
    return parent[a]


sum = 0
for w, s, e in edges:
    if find(s) != find(e):
        union(s, e)
        sum += w

print(sum)
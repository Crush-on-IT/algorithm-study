# 백준1647\_도시 분할 계획

### &#127822; 분류

MST, Kruskal

### &#127822; 코드

```python
import sys

V, S = map(int, sys.stdin.readline().split())

edges = []
for _ in range(S):
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
        last = w
        sum += w

print(sum - last)
```

### &#127822; 풀이 방법

MST 문제 해결중 그 과정을 알고 있는지 묻는 문제이다.

도시를 2개로 나눈다는 것은 MST에서 가장 큰 Edge를 제거하면 되는 것이다. (cycle이 없기 때문)

따라서 Kruskal의 경우, 마지막 추가된 edge의 weight를 무시하면 된다.

Prim의 경우도 마찬가지이기 때문에 반복문을 V-1이 아닌 V-2까지만 돌리면 된다.

### &#127822; 느낀점

Prim이 더 효율적일거라 생각해서 했더니 오히려 시간초과나고, Kruskal이 통과되었다. 시간 복잡도에 대해 분석해 봐야겠다.
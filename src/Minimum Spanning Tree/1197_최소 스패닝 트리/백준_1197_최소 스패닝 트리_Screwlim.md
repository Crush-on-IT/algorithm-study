# 백준1197\_최소 스패닝 트리

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
    if find(s) != find(e):#싸이클이 아님을 확인
        union(s, e)
        sum += w

print(sum)
```

### &#127822; 풀이 방법

Kruskal은 경로찾기에서 Bellman-ford처럼 edge의 관점으로 tree를 완성하는 알고리즘이다.

1. 입력받은 edge들의 정보를, edge의 가중치순으로 정렬한다. (최소비용을 찾는 과정이기에)

2. 가장 가중치가 작은 edge부터 순회하며 tree를 추가한다. (이번 문제의 경우 tree를 생성하는 게 아니라 최소비용을 찾는 것이기에 sum만 기록)

3. 각 edge가 추가 될때, cycle이 생기는 지 확인한다.

4. cycle을 확인하기 위해서는 Union / Find 방법을 활용함.

    각 node의 parent를 확인하고 경로를 압축하는 find 함수와 edge를 추가할 시 새로 연결되는 node의 parent를 기록하는 union함수로 싸이클을 확인한다.

5. 주어진 간선을 모두 순회한 후에는 싸이클이 없는 최소간선들을 선택한 MST가 생성된 것이다.

### &#127822; 느낀점

MST는 Kruskal, Prim알고리즘 두가지로 풀 수 있다. 이번에는 Kruskal로 풀었는데, Prim풀이도 해봐야 할 듯
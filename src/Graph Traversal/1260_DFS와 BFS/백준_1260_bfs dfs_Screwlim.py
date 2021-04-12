import sys

n, m, v = map(int, sys.stdin.readline().rstrip().split(" "))

# 빈 tree 생성
tree = [[0 for i in range(n+1)] for k in range(n+1)]

# 간선 입력
for i in range(m):
    fromNode, toNode = map(int, sys.stdin.readline().rstrip().split(" "))
    tree[fromNode][toNode] = 1
    tree[toNode][fromNode] = 1

def dfs(node):
    visited[node] = 1
    print(node, end=" ")
    for i in range(1, n+1):
        if visited[i] == 0 and tree[node][i] == 1:
            dfs(i)

def bfs(node):
    visited[node] = 1
    q = [node]

    while q:
        node = q.pop(0)
        print(node, end=" ")
        for i in range(1, n+1):
            if visited[i] == 0 and tree[node][i] == 1:
                q.append(i)
                visited[i] = 1

visited = [0 for i in range(n+1)]
dfs(v)
print()
visited = [0 for i in range(n+1)]
bfs(v)
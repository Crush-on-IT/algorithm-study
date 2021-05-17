# 백준11403\_경로 찾기

### &#127822; 분류

Shortest Path, Floyd Warshall

### &#127822; 코드

```python
import sys

n = int(sys.stdin.readline().rstrip())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if arr[i][k] == 1 and arr[k][j] == 1:
                arr[i][j] = 1

for i in range(n):
    for j in range(n):
        print(int(arr[i][j]), end=" ")
    print()
```

### &#127822; 풀이 방법

각 노드에서 갈 수 있는 노드를 계산하는 문제이다. 플로이드 와샬 알고리즘을 조금 변형하면 풀 수 있는 문제이다.

각 노드별로 경로를 확인할 때, 최소 비용을 확인하는 대신 길이 있는지 여부만 체크해서 값을 넣어준다.

### &#127822; 느낀점

Floyd Warshall 별거 아니다!
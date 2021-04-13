# 백준2667\_단지번호붙이기

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque

n = int(sys.stdin.readline())

map = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(n)]

stack = deque()

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
housenum = 1
nums = []

def bfs(node, housenum):
    houses = 1
    map[node[0]][node[1]] = housenum
    while stack:
        here = stack.popleft()
        for i in range(4):
            next_x = here[1] + move_x[i]
            next_y = here[0] + move_y[i]
            if 0 <= next_x < n and 0 <= next_y < n:
                if map[next_y][next_x] == 1:
                    houses += 1
                    map[next_y][next_x] = housenum
                    stack.append([next_y, next_x])
    nums.append(houses)


for i in range(n):
    for k in range(n):
        if map[i][k] == 1:
            stack.append([i, k])
            housenum += 1
            bfs([i, k], housenum)


nums.sort()
print(housenum - 1)
for i in nums:
    print(i)

```

### &#127822; 풀이 방법

1. 이전 토마토 문제와 유사하다 -> bfs로

2. 우선 지도 전체를 한번 순회하며 1(집)을 찾는다.

3. 집을 찾을 경우 stack에 넣고 해당 집부터 주변을 탐색하며 주택가를 형성한다. (기존 1의 값에서 2이상의 정수로 바꿔줌)

4. 주택가가 형성이되면 다시 지도 순회로 돌아와 아직 주택가로 처리되지 않은 집을 찾는다.

### &#127822; 느낀점

이전 [토마토](https://github.com/Crush-on-IT/algorithm-study/blob/main/src/Graph%20Traversal/7576_토마토/백준_7576_토마토_Screwlim.md) 문제와 비슷하게 주어진 데이터에 대해서 주변값을 탐색해야 하면 bfs가 적절한 것 같다. 특히나 탐색을 진행하며 해당 값의 변화를 순차적으로 일으키는 경우는 더더욱.
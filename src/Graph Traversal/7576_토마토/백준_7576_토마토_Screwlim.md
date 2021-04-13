# 백준7576\_토마토

### &#127822; 분류

Graph traversal, BFS

### &#127822; 코드

```python
import sys
from collections import deque

x, y = map(int, sys.stdin.readline().split())
stack = deque()
#tree 생성
box=[list(map(int,sys.stdin.readline().split())) for _ in range(y)]

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]
ans = 0

for i in range(y):
    for k in range(x):
        if box[i][k] == 1:
            stack.append([i, k])

while stack:
    now = stack.popleft()
    print(now)
    if box[now[0]][now[1]] > ans:
        ans = box[now[0]][now[1]]
    for i in range(4):
        now_x = now[1] + move_x[i]
        now_y = now[0] + move_y[i]
        if 0 <= now_x < x and 0 <= now_y < y:
            if box[now_y][now_x] == 0:
                stack.append([now_y, now_x])
                box[now_y][now_x] = box[now[0]][now[1]] + 1


for k in range(y):
    for i in range(x):
        if box[k][i] == 0:
            ans = 0
print(ans-1)
```

### &#127822; 풀이 방법

1. 주어진 데이터를 읽고 해당 Tree(box)를 생성한다. (이중 배열로 구현)

2. 토마토가 있는 index를 모두 stack에 저장한다.

3. stack에 있는 값들을 차례로 순회(bfs)한다.

4. 순회하며 순회하기 한 단계 전의 좌표값(지난 시간을 의미)에 1씩 증가하며 값을 넣어준다.

5. box에 담긴 값들 중 max값을 출력한다. 혹은 0이 있을 경우 전체 순회가 불가능한 경우이기에 -1을 출력한다.

### &#127822; 느낀점

전형적이 bfs문제였다. 다만 시작점이 여러군데 일 수 있기에 시작점들을 모두 미리 큐에 넣어두고 시작한다는 점이 조금 변형이였다.

"문제의 조건에서 입력값 M,N은 2이상이라고 두었는데 계속 에러가 나서 봤더니, M,N이 1인경우에 배열 선언에서 에러가 나더라

혹시나 해서 M,N이 1인 경우에도 에러가 나지않게 고쳤더니 정답이더라."

인줄 알았는데 입력값에 m,n이 1인 경우 조건으로 확인해 보았더니 아니더라..

배열 선언과정에서 문제가 있었던것 같은데 추후에 깊게 파도록 해보자
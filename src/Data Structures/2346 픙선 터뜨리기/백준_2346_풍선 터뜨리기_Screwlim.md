# 백준2346\_풍선 터뜨리기

### &#127822; 분류

Deque

### &#127822; 코드

```python
from collections import deque
import sys

balloon_num = int(sys.stdin.readline().rstrip())

balloons = deque(range(1,balloon_num+1))
val = sys.stdin.readline().rstrip().split(" ")
balloons_val = []
index = 0
ans = ""

for i in val:
    balloons_val.append(int(i))

for i in range(balloon_num):
    index = balloons.popleft()
    ans += str(index) + ' '
    if balloons_val[index-1] > 0:
        balloons.rotate(-(int(balloons_val[index - 1])-1))
    else:
        balloons.rotate(-(1+int(balloons_val[index - 1]) - 1))

print(ans.rstrip())

```

### &#127822; 풀이 방법

풍선 안에 적혀져있는 수 만큼 이동하며 차례대로 터뜨리는, 순서를 계산하는 문제이다. Circular Queue이기에 Deque로 구현하여 해결하였다.

1. 각 풍선의 번호를 Deque에 삽입한다.

2. 각 풍선 안에 적혀져있는 이동하는 수는 list에 값을 저장하여 조회할 수 있도록 한다.

3. 풍선을 순회할 때 터뜨린 풍선은 pop한 후, 해당 풍선의 이동값을 조회하여 그 값만큼 rotate시키도록 하였다.

4. 총 풍선의 갯수만큼 순회하도록 한다.

### &#127822; 느낀점

deque는 매우 편리하고 빠르다.
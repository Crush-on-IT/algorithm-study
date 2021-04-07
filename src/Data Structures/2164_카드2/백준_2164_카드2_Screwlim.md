# 백준18258\_카드2

### &#127822; 분류

Queue

### &#127822; 코드

```python
from collections import deque
import sys

cards_num = int(sys.stdin.readline().rstrip())
q = deque()
q_len = 0

for i in range(cards_num, 0, -1):
    q.append(i)

while len(q) != 1:
    q.pop()
    q.rotate(1)

print(q.pop())

```

### &#127822; 풀이 방법

1. deque를 활용하여 제시한 로직 그대로 동작시켰다.

### &#127822; 느낀점

queue는 list가 아닌 deque로 구현하자
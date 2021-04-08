# 백준1874\_스택 수열

### &#127822; 분류

Stack

### &#127822; 코드

```python
from collections import deque
import sys

seq_len = int(sys.stdin.readline().rstrip())
seq = []

ans=""
queue = deque()
max_in = 0

for i in range(seq_len):
    seq.append(int(sys.stdin.readline().rstrip()))

for i in seq:
    if i > max_in:
        for k in range(max_in+1, i+1):
            queue.append(k)
            ans += "+\n"
        max_in = i
        queue.pop()
        ans += "-\n"
    else:
        if i == queue.pop():
            ans += "-\n"
        else:
            print("NO")
            sys.exit()

print(ans)
```

### &#127822; 풀이 방법

1. 주어진 수열이 스택의 append, pop으로 구현할 수 있으면 그 과정을, 못한다면 NO를 출력하는 문제이다.

2. 스택의 성질에 의해 first in first out에 어긋나는 경우가 있으면 바로 NO를 출력하게 하면 된다.

3. 그 외에는 해당 숫자까지 append 혹은 수열에 맞는 숫자가 있으면 pop하여 출력하도록 한다.

### &#127822; 느낀점

stack 자체의 성질을 그대로 사용하면 되는데 괜히 여러 경우의 수를 분기할 뻔했다.

아직 머리로 먼저 부딫히는 습관이 있다.

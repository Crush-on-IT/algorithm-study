# 백준18258\_큐 2

### &#127822; 분류

Queue

### &#127822; 코드

```python
from collections import deque
import sys
command_num = int(sys.stdin.readline().rstrip())
q = deque()
q_len = 0

ans = ""

for i in range(0, command_num):
    command = sys.stdin.readline().rstrip().split(' ')
    if command[0][1] == "u":
        q.append(command[1])
        q_len = q_len + 1
    elif command[0][1] == "o":
        if q_len == 0:
            ans += '-1\n'
        else:
            ans += str(q.popleft()) + '\n'
            q_len = q_len - 1
    elif command[0][1] == "i":
        ans += str(q_len) + '\n'
    elif command[0][1] == "m":
        if q_len == 0:
            ans += '1\n'
        else:
            ans += '0\n'
    elif command[0][1] == "r":
        if q_len == 0:
            ans += '-1\n'
        else:
            ans += str(q[0]) + '\n'
    elif command[0][1] == "a":
        if q_len == 0:
            ans += '-1\n'
        else:
            ans += str(q[q_len-1]) + '\n'

print(ans)

```

### &#127822; 풀이 방법

1. 명령어를 string으로 받아 if, elif로 분기하여 처리한다.

2. deque 객체를 활용하여 queue를 구현.

### &#127822; 느낀점

초기 코드의 모습은 아래와 같다.

```python
command_num =  int(input())
stack = []
stack_len = 0

ans = ""

for i in range(0, command_num):
    command = input().split(' ')
    if command[0] == "push":
        stack.append(command[1])
        stack_len = stack_len + 1
    elif command[0] == "pop":
        if stack_len == 0:
            ans += '-1\n'
        else:
            ans += str(stack.pop(0)) + '\n'
            stack_len = stack_len - 1
    elif command[0] == "size":
        ans += str(stack_len) + '\n'
    elif command[0] == "empty":
        if stack_len == 0:
            ans += '1\n'
        else:
            ans += '0\n'
    elif command[0] == "front":
        if stack_len == 0:
            ans += '-1\n'
        else:
            ans += str(stack[0]) + '\n'
    elif command[0] == "back":
        if stack_len == 0:
            ans += '-1\n'
        else:
            ans += str(stack[stack_len-1]) + '\n'

print(ans)
```

이 코드는 로직은 같지만 시간 초과로 통과되지 않았다.

string비교나 queue에 값을 넣거나 빼는 함수가 실행시간이 오래 걸린다 생각하여 다른 로직들을 생각했지만 사실 로직에서는 문제될 것이 없었다.

찾아보니 python은 실행이 느린 언어인데다가 많은 경우 입출력에서 시간이 오래걸린다고 한다.

input()이 아닌 sys.stdin.readline()을 통해 입출력 시간을 줄이고 또한 list가 아닌 deque 객체를 활용하였더니 실행시간이 빨라져 통과되었다.

혹시나 싶어 입력된 명령어들을 비교하는 연산도 줄일 수 있나 싶어 size를 i로 구분하는 등 비교되는 문자열을 줄여보았지만 실행시간에 무관한 것 같았다.

이제 안 것이 부끄럽구만
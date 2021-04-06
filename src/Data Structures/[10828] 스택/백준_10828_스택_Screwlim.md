# 백준10828_스택

### &#127822; 분류

Stack

### &#127822; 코드

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
            # print(-1)
        else:
            ans += str(stack.pop()) + '\n'
            # print(stack.pop())
            stack_len = stack_len - 1
    elif command[0] == "size":
        # print(stack_len)
        ans += str(stack_len) + '\n'
    elif command[0] == "empty":
        if stack_len == 0:
            # print(1)
            ans += '1\n'
        else:
            ans += '0\n'
            # print(0)
    elif command[0] == "top":
        if stack_len == 0:
            ans += '-1\n'
            # print(-1)
        else:
            ans += str(stack[stack_len-1]) + '\n'
            # print(stack[stack_len-1])

print(ans)
```

### &#127822; 풀이 방법

1. stack의 개념과 명령어를 처리하는 방법이 핵심이다.

2. list로 stack을 구현한다.

3. push, pop. size, empty, top에 따른 조건문으로 명령어를 수행하도록 한다.

4. 답 출력은 한번에 string으로 한다.

### &#127822; 느낀점

주석 지저분해서 지우고 다시 재 채점 했더니 시간초과가 떴다.

주석이 있어야 정상적으로 채점된다.

이유를 모르겠다.

python에서는 switch문이 없기에 if, elif로 구현했는데 이러한 경우 다른 효율적인 구현방법을 찾아봐야겠다.

# 백준10828\_스택

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

1. 괄호의 열고 닫음을 stack으로 계산하여 옳고 그름을 판단한다.

2. 괄호가 정상적으로 열고 닫힌 경우는 마지막엔 stack이 비어있다.

3. 괄호가 비정상적으로 열고 닫힌 경우 stack에 괄호가 남아있거나 비어있는 상황에서 pop을 요청하게 된다.

4. stack을 list로 구현할 필요없이 단순히 정수 연산으로 계산한다. (열때 +1, 닫을때 -1, 큐가 비어있으면 0)

### &#127822; 느낀점

자료구조의 성질을 단순한 연산으로 비유하여 풀이함.

python 풀이와 비교하였을 때 메모리는 비슷하게 사용하였는데 시간이 조금 더 오래걸렸다.

입출력에서 차이가 있는 듯 하다.
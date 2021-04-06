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

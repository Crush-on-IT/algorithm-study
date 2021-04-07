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

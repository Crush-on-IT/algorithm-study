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
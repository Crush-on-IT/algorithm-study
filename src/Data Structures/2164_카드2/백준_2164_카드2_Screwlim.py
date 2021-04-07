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

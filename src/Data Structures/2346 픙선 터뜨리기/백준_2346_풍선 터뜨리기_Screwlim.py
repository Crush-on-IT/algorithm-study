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
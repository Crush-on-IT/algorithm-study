import sys

customers = int(sys.stdin.readline().rstrip())
tips = []
answer = 0
for _ in range(customers):
    tips.append(int(sys.stdin.readline().rstrip()))

tips.sort(reverse=True)

for i in range(customers):
    temp = tips[i] - i
    if temp > 0:
        answer += temp
    else:
        continue

print(answer)
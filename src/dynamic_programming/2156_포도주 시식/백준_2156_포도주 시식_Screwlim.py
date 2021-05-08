import sys

N = int(sys.stdin.readline().rstrip())
wines = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
drink = [0 for _ in range(N)]

if N < 2:
    wines.append(0)
    drink.append(0)

drink[0] = wines[0]
drink[1] = wines[0] + wines[1]

for i in range(2, N):
    drink[i] = max(drink[i-3] + wines[i-1] + wines[i], drink[i-2] + wines[i], drink[i-1])

print(drink[-1])
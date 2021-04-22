import sys

N, C = map(int, sys.stdin.readline().rstrip().split())
houses = [int(sys.stdin.readline()) for _ in range(N)]
houses.sort()

min = 1
max = houses[N-1] - houses[0]
ans = 1

while min <= max:
    pivot = (min + max) // 2
    installed = 1
    before_house = houses[0]
    for house in houses:
        if pivot <= house - before_house:
            installed += 1
            before_house = house
    if installed >= C:
        ans = pivot
        min = pivot + 1
    else:
        max = pivot - 1

print(ans)
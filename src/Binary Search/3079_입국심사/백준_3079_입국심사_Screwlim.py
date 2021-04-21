import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
times = [int(sys.stdin.readline()) for _ in range(N)]

times.sort()
left = min(times) 
answer = right = max(times)*M

while left <= right:
    pivot = (left + right) // 2
    passed = 0
    for time in times:
        passed += pivot // time

    if passed >= M:
        right = pivot - 1
        answer = min(answer, pivot)
    else:
        left = pivot + 1

print(answer)
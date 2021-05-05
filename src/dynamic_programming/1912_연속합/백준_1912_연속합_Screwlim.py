import sys

N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
sum_max = [0 for _ in range(N)]
Max = -1001
for i in range(1, N):
    sum_max[i] = max(sum_max[i-1] + nums[i], nums[i])
    Max = max(Max, sum_max[i])

print(Max)
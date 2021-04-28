import sys


def dfs(index, sums):
    global N, M, case
    if index >= N:
        return
    new_sum = sums + nums[index]
    if  new_sum == M:
        case += 1
    dfs(index + 1, new_sum)
    dfs(index + 1, sums)


N, M = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
nums.sort()
case = 0
dfs(0, 0)
print(case)

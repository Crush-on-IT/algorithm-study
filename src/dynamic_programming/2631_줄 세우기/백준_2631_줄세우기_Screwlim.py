import sys

n = int(sys.stdin.readline().rstrip())
kids = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

dp = [1] * n
for i in range(n):
    for j in range(i):
        if kids[i] > kids[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
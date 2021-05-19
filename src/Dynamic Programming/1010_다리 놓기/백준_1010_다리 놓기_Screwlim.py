import sys
import math

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    ans = math.factorial(b) // (math.factorial(a) * math.factorial(b - a))
    print(ans)
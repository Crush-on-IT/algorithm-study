import sys

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())

ans = -1
_min = 1
_max = N*N

while _min <= _max:
    pivot = (_min + _max)//2
    print(_min, _max)
    smaller_nums = 0
    for i in range(1, N+1):
        smaller_nums += min(pivot//i, N)

    if smaller_nums >= K:
        ans = pivot
        _max = pivot - 1
    else:
        _min = pivot + 1
print(ans)
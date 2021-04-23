import sys

K, N = map(int, sys.stdin.readline().rstrip().split())
lines = [int(sys.stdin.readline().rstrip()) for _ in range(K)]

ans = 0
_min = 1
_max = max(lines)


def check_cuts(limit):
    counts = 0
    for line in lines:
        counts += line // limit
    if counts >= N:
        return True
    else:
        return False


while _min <= _max:
    pivot = (_min + _max) // 2
    if check_cuts(pivot):
        ans = pivot
        _min = pivot + 1
    else:
        _max = pivot - 1

print(ans)
import sys

N, M, L = map(int, sys.stdin.readline().rstrip().split())
stations = list(map(int, sys.stdin.readline().rstrip().split()))
stations.append(0)
stations.append(L)
stations.sort()
_min = 0
_max = L-1
ans = 1

while _min <= _max:
    pivot = (_min + _max) // 2
    built = 0
    for i in range(1, len(stations)):
        if stations[i] - stations[i-1] > pivot:
            built += (stations[i] - stations[i-1] - 1) // pivot

    if built > M:
        _min = pivot + 1
    else:
        ans = pivot
        _max = pivot - 1

print(ans)
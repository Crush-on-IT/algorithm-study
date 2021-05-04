import sys

N = int(sys.stdin.readline())
arr = [0, 0, 1, 1]

for i in range(4, N+1):
    arr.append(arr[i-1]+1)

    if i%2 == 0:
        arr[i] = min(arr[i], arr[i//2]+1)

    if i%3 == 0:
        arr[i] = min(arr[i], arr[i//3]+1)

print(arr[N])

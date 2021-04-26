import sys
input = sys.stdin.readline
 
 
def DFS(i):
    global N, col, slash, backSlash, case
    if i == N:
        case += 1
        return
    for j in range(N):
        if not (col[j] or slash[i + j] or backSlash[i - j + N - 1]):
            col[j] = slash[i + j] = backSlash[i - j + N - 1] = True
            DFS(i + 1)
            col[j] = slash[i + j] = backSlash[i - j + N - 1] = False
 
 
N = int(input())
col, slash, backSlash = [False] * N, [False] * (2 * N - 1), [False] * (2 * N - 1)
case = 0
 
DFS(0)
 
print(case)
import sys

N = int(sys.stdin.readline().rstrip())
gameboard = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
history = [[-1 for _ in range(N)] for _ in range(N)]


def jump(y, x):
    global case
    print(y, x)
    if y >= N or x >= N:
        return 0
    if y == N-1 and x == N-1:
        return 1

    if history[y][x] != -1:
        return history[y][x]

    history[y][x] = 0
    jump_step = gameboard[y][x]
    move_ywards = jump(y + jump_step, x)
    move_xwards = jump(y, x + jump_step)

    history[y][x] += move_xwards + move_ywards

    return history[y][x]


print(jump(0, 0))

import sys

n = int(sys.stdin.readline().rstrip())

board = [['*' for _ in range(n)] for _ in range(n)]


def draw_star(size):

    global board, n

    if size == 1:
        return
    blank_size = size//3
    for i in range(0, n, size):
        for j in range(0, n, size):
            for k in range(blank_size**2):
                x = k%(size//3) + j + size//3
                y = k//blank_size + i + size//3
                board[y][x] = " "

    draw_star(size//3)


draw_star(n)

for i in range(n):
    for j in range(n):
        print(board[i][j], end="")
    print("")

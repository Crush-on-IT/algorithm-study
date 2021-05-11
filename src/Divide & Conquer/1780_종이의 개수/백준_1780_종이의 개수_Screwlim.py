import sys

n = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
zero, plus, minus = 0, 0, 0


def find_color(x, y, side_len):
    global zero, plus, minus, paper

    flag = paper[x][y]

    for i in range(x, x + side_len):
        for j in range(y, y + side_len):
            if paper[i][j] != flag:
                flag = -2
                break

    if flag == 0:
        zero += 1
    elif flag == 1:
        plus += 1
    elif flag == -1:
        minus += 1
    else:
        side_len = side_len // 3
        find_color(x, y, side_len)
        find_color(x + side_len, y, side_len)
        find_color(x + side_len*2, y, side_len)

        find_color(x, y + side_len, side_len)
        find_color(x + side_len, y + side_len, side_len)
        find_color(x + side_len*2, y + side_len, side_len)

        find_color(x, y + side_len*2, side_len)
        find_color(x + side_len, y + side_len*2, side_len)
        find_color(x + side_len*2, y + side_len*2, side_len)
        return


find_color(0, 0, n)
print(minus)
print(zero)
print(plus)

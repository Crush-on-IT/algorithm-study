import sys

n = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
white, blue = 0, 0


def find_color(x, y, side_len):
    global white, blue
    cnt = 0
    for i in range(x, x + side_len):
        for j in range(y, y + side_len):
            if paper[i][j]:
                cnt += 1

    if cnt == 0:
        white += 1
    elif cnt == side_len**2:
        blue += 1
    else:
        find_color(x, y, side_len // 2)
        find_color(x + side_len // 2, y, side_len // 2)
        find_color(x, y + side_len // 2, side_len // 2)
        find_color(x + side_len // 2, y + side_len // 2, side_len // 2)
    return


find_color(0, 0, n)
print(white)
print(blue)
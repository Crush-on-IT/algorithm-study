import sys

n, Y, X = map(int, sys.stdin.readline().split())
board = [[0 for _ in range(2**n)] for _ in range(2**n)]
step = 0


# def travel(x, y, size):
#     global board, step
#
#     if size == 1:
#         board[y][x] = step
#         step += 1
#         return
#     else:
#         smaller_size = size // 2
#         travel(x, y, smaller_size)
#         travel(x + smaller_size, y, smaller_size)
#         travel(x, y + smaller_size, smaller_size)
#         travel(x + smaller_size, y + smaller_size, smaller_size)
#
#     return
#
#
# travel(0, 0, 2**n)
#
# for i in range(2**n):
#     print(board[i])
#
# print(board[Y][X])


def travel(x, y, size):
    global board, step, X, Y
    print(x, y, size, end=' ')
    print(step)

    if x == X and y == Y:
        print(step)
        sys.exit()
    else:
        smaller_size = size // 2
        if x <= X < x+smaller_size and y <= Y < y+smaller_size:
            print("1사분면")
            travel(x, y, smaller_size)
        elif x+smaller_size <= X < x+size and y <= Y < y+smaller_size:
            print("2사분면")
            step += smaller_size**2
            travel(x + smaller_size, y, smaller_size)
        elif x <= X < x+smaller_size and y+smaller_size <= Y < y+size:
            print("3사분면")
            step += (smaller_size**2)*2
            travel(x, y + smaller_size, smaller_size)
        else:
            print("4사분면")
            step += (smaller_size ** 2) * 3
            travel(x + smaller_size, y + smaller_size, smaller_size)

    return


if __name__ == "__main__":

    travel(0, 0, 2**n)

    print(step)
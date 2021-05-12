# 백준1074\_Z

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
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

    if x == X and y == Y:
        print(step)
        sys.exit()
    else:
        smaller_size = size // 2
        if x <= X < x+smaller_size and y <= Y < y+smaller_size:
            travel(x, y, smaller_size)
        elif x+smaller_size <= X < x+size and y <= Y < y+smaller_size:
            step += smaller_size**2
            travel(x + smaller_size, y, smaller_size)
        elif x <= X < x+smaller_size and y+smaller_size <= Y < y+size:
            step += (smaller_size**2)*2
            travel(x, y + smaller_size, smaller_size)
        else:
            step += (smaller_size ** 2) * 3
            travel(x + smaller_size, y + smaller_size, smaller_size)

    return


if __name__ == "__main__":

    travel(0, 0, 2**n)
```

### &#127822; 풀이 방법

찾고자 하는 좌표를 탐색하는 순서를 얻는다.

1. 전체 좌표를 4등분해서 몇 사분면에 목적 좌표가 포함되는 지 찾는다.

2. 각 포함되는 사분면만 다시 탐색한다.

3. 1사분면을 제외하고 나머지는 2,3,4는 각각 1,2,3개의 사분면을 지난 후 순회하기 때문에 각 지나친 사분면만큼 값을 step에 더해준다.

4. 목적 좌표에 도달했을 경우, step을 출력한다.

### &#127822; 느낀점

처음에는 일일히 순회하며 step을 증가시키며 찾았는데, 이는 n이 커질수록 연산이 매우 많아지므로 시간초과가 발생함.

좌표는 계산할 수 있으므로 순회하지 않고 계산하되, 계산하는 값의 범위를 찾는데 Divide & Conquer는 그대로 적용되었다.
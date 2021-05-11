# 백준1780\_종이의 개수

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
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
```

### &#127822; 풀이 방법

분할정복문제이다.

각 종이의 사이즈별로 색종이가 한 덩어리인지 확인하며 점점 작게 나누어진다.

1. 색종이의 좌측상단 좌표와 한 변의 길이를 정할 때 마다 색종이를 자른다.

2. 첫 좌표부터 순회하며 한변의 길이 안이 모두 파란색인지 확인한다.

3. count된 값이 n^2일 경우 모두 파란색이므로, 파란색 한장, 0일 경우 하얀색 한장으로 치므로 각 변수를 증가시킨다.

4. 만약 그 외의 값일 경우, 색이 섞인 경우이므로 종이를 4분할 하여 다시 진행한다.

### &#127822; 느낀점

분할 정복의 대표 예제 느낌이다. 이 분야도 DP처럼 많이 풀어봐야 할 듯

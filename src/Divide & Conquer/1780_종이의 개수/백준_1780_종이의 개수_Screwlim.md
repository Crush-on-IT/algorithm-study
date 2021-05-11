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

분할정복문제이다. 색종이 만들기와 유사하다.

각 종이의 사이즈별로 색종이가 한 덩어리인지 확인하며 점점 작게 나누어진다. 이 문제의 경우 종이의 종류가 3가지이다.

1. 색종이의 좌측상단 좌표와 한 변의 길이를 정할 때 마다 색종이를 자른다.

2. 첫 좌표 값을 flag에 저장하고 순회하며 종이의 값이 flag와 모두 동일한지 확인한다.

3. 다른경우 flag값을 -2로 초기화한다. 

4. flag값이 -1, 0, 1중 하나일 경우, 각 count를 증가하고 -2이면 깂이 여러개로 섞인 경우이므로 종이를 9분할 하여 다시 진행한다.

### &#127822; 느낀점

변형문제
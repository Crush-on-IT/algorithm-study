# 백준2447\_별 찍기 - 10

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
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

```

### &#127822; 풀이 방법

분할 정복문제라기 보단, 재귀함수 문제 같았다.

1. 모든 칸에 * 이 찍힌 board를 초기화 한다.

2. 반복되는 패턴은 3의 약수로 작아진다.

3. n부터 점점 3으로 나눠가며 패턴을 종이에 찍는다.

4. n이 1일 때 종료된다.

### &#127822; 느낀점

size에 따라 재귀로 풀긴 풀었는데 풀고나니 D & Q가 아니라 패턴을 찾아 해결한거 같다 ㅜ
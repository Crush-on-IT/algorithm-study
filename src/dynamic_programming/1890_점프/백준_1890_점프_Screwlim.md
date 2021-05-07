# 백준1890\_점프

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
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
```

### &#127822; 풀이 방법

DP를 공부하다 종만북에서 예제로 나온 유형과 비슷한 문제였다.

시작점부터 이동 가능한 점을 찾아 탐색한다.

만약 이전에 탐색했을 경우 memoization을 통해 더 연산하지 않고도 해당 지점을 지나 도달할 수 있는 경로의 수를 얻는다.

최종 return값은 곧 목적지 까지의 경로수가 된다.

### &#127822; 느낀점

지도, gameboard와 같은 어떠한 좌표평면위 탐색과 관련된 DP문제들에 조금 익숙해 진 것 같다.

DP 문제유형들과 분할정복과 다른점을 비교하는데 공부가 많이된 문제였다.

memoization 매우 중요
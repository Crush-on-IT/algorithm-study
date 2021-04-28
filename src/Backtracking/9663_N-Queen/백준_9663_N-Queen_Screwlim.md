# 백준9663\_N-Queens

### &#127822; 분류

Backtracking, BFS

### &#127822; 코드

```python
import sys
input = sys.stdin.readline
 
 
def DFS(i):
    global N, col, slash, backSlash, case
    if i == N:
        case += 1
        return
    for j in range(N):
        if not (col[j] or slash[i + j] or backSlash[i - j + N - 1]):
            col[j] = slash[i + j] = backSlash[i - j + N - 1] = True
            DFS(i + 1)
            col[j] = slash[i + j] = backSlash[i - j + N - 1] = False
 
 
N = int(input())
col, slash, backSlash = [False] * N, [False] * (2 * N - 1), [False] * (2 * N - 1)
case = 0
 
DFS(0)
 
print(case)
```

### &#127822; 풀이 방법

주어진 조건에 따르면, 각 줄마다 

1. 초기 범위는 1 ~ N*N 이다.

2. 어떠한 값보다 작은 곱의 갯수는 다음과 같이 count한다.
    
    i번째 행에는 ix1, ix2, ix3 ... 로 구구단처럼 값이 ixN까지 이어져 있다.

    이 값들 중에서 주어진 pivot값보다 작은 값의 갯수를 얻는 것은 pivot/i 의 몫이다.
    
    단, 해당 몫이 N보다 클경우, N을 더한다. 배열의 크기가 NxN이기 때문.
    
3. pivot값을 설정하고, 해당 pivot값을 답이라 생각하고 배열안에서 해당 값보다 작은 수의 갯수를 count한다.

4. 해당 count 값이 K보다 큰 경우, 값을 줄이는 방향으로, 작은경우, 값을 늘이는 방향으로 설정한다.

5. 이진탐색을 하여 적절한 K값을 찾는다.

### &#127822; 느낀점

일단 이 코드는 내가 짠게 아니라 [여기](https://hellominchan.tistory.com/176)의 코드를 가지고 온 것이다...

3번째 시도에 다다른 풀이인데, 로직은 거의 같았지만 이분의 코드가 더 깔끔해서 가져왔다.

풀이과정을 정리해 보자면...


### 1차시도

이론대로 정석적인 풀이를 했다.

문제에서 제시한 상황 그대로 인접 배열을 생성하고, 매번 Queen을 배치할 때 마다 Queen이 배치될 수 없는 지점을 체크하였고, 이를 바탕으로 backtracking을 실행하였다.

하지만 시간초과가나서 풀이가 너무 simulation적인 면이 많다고 생각하여 연산과 탐색을 더 줄여봐야겠다고 생각하여 수정하였다.

### 2차시도
코드를 작성하다가 로직에 문제를 발견해 다시 처음부터 구상했다.

해당 코드는 아래와 같다.
```python
import sys


def dfs(x):
    global answer, ups
    not_prominent = set()
    if x == N:
        answer += 1

    for i in ups:
        not_prominent.add(i)
    for i in left_diag:
        i -= 1
        if i < 0:
            left_diag.remove(i)
        else:
            not_prominent.add(i)
    for i in right_diag:
        i += 1
        if i >= N:
            right_diag.remove(i)
        else:
            not_prominent.add(i)
    for i in range(N):
        if i not in not_prominent:
            dfs(i+1)


N = int(sys.stdin.readline().rstrip())
ups = []
left_diag = []
right_diag = []
answer = 0
dfs(0)
print(answer)
```

시도하려고 했던 바는, 인접행렬을 없애는 것이다.

인접행렬로 각 칸의 유망성을 확인하려면 메모리도 메모리지만 매번 Queen이 배치될 때, 전체 game board를 순회하여야 하기에 dfs특성상 이는 너무 비효율적이라 생각했다.

따라서 각 행마다 어차피 배치되는 Queen은 하나이기에, 각 칸마다 검사해야하는 자리는 왼쪽 대각선 위, 오른쪽 대각선 위, 바로 위칸 이 세 방향이다.

매번 한 열씩 유망성을 다시 검사하며 아래로 순회를 이룰 시, 배열의 순회는 일어나지만 game board만큼은 아니고 필수적인 칸만 유망성을 확인하기에 연산이 많이 줄어든다고 생각했다.

그러나 dfs특성상 각 depth별 시도했던 유망성에 대해 검사 후 다시 이전 단계로 되돌려야 하는데 이 과정이 오히려 연산이 더 많아진다 생각되어 중단했다.

### 3차시도
마지막 로직은 위 코드와 유사하다.

유망성 확인을 하는 것은 앞서 말한 3가지 방향만 하는 것은 동일하다.

각 행씩 검사할 때, 유망성 검사를 위해서는 대각선 방향을 검사하는 것이 문제가 되는데, 이 부분을 나는 왼쪽 대각선의 경우 행의 차이를 똑같이 열에 빼면 되고, 오른쪽 대각선은 반대로 더해주면 된다. 하지만 이 경우 어차피 다시 지나온 행을 모두 순회해 보아야 하는 단점이 있다.

하지만 참고한 분의 코드는 대각선 인덱스들의 규칙성으로 2 X N - 1 크기의 배열에 대각선 정보를 모두 저장하여, 1번의 조회로 유망성을 확인할 수 있었다.

아직 난 갈 길이 먼 듯 하다.

### 결론
풀이를 마치고 다른 풀이를 찾아보니 어처구니 없게도, N<15라는 조건을 활용해 그저 15개의 정답을 넣어둔 배열을 답으로 제출한 경우 정답처리가 되는 현실을 마주했다.

파이썬이 워낙 느리기 때문에 dfs, backtracking, greedy등과 같은 문제들은 위에서 내가한 과정처럼 추가적으로 연산을 줄이는 과정이 필요한 경우가 많다고 한다.

이론대로라면 로직은 맞다는 소리다.

현타온다.
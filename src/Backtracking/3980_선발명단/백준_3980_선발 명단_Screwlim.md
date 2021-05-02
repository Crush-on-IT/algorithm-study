# 백준3980\_선발 명단

### &#127822; 분류

Backtracking, BFS

### &#127822; 코드

```python
import sys


def try_team(player_number, cur_abil, test_case):
    global Tests, max_abil, recruited

    if (11 - player_number)*100 < max_abil - cur_abil:
        return

    if player_number == 11:
        max_abil = max(max_abil, cur_abil)
        return

    for i in range(11):
        if not recruited[i] and test_case[player_number][i] != 0:
            recruited[i] = True
            temp = cur_abil + test_case[player_number][i]
            try_team(player_number+1, temp, test_case)
            recruited[i] = False


N = int(sys.stdin.readline().rstrip())
Tests = [[list(map(int, sys.stdin.readline().split())) for _ in range(11)] for _ in range(N)]

for i in range(N):
    max_abil = 0
    recruited = [False] * 11
    try_team(0, 0, Tests[i])
    print(max_abil)
```

### &#127822; 풀이 방법

외판원 순회 문제의 변형같다. 풀이는 다음과 같다.

1. 각 테스트케이스 별로 입력을 받는다.

2. 선수의 수는 11명으로 정해져 있으므로, 각 선수별로 가능한 포지션을 dfs로 탐색한다.

3. 탐색하며 현재까지의 능력 최대치 값을 저장하고 이를 매번 다음 횟수에서 유망성 검사를 한다. (현재까지의 능력최대치 + 앞으로 더할 수 있는 능력 최대치 VS 현재 저장된 최대 능력치 합)

4. 순회를 마치면 max_abil에 저장된 값을 출력한다.

5. 테스트 케이스별로 위를 진행한다.

### &#127822; 느낀점

외판원 순회와 유사하다.

python으로 풀고 제출했는데 유망성 검사를 제외한게 더 빨랐다. 왜..?
# 백준1182\_부분수열의 합

### &#127822; 분류

Backtracking, DFS

### &#127822; 코드

```python
import sys


def dfs(index, sums):
    global N, M, case
    if index >= N:
        return
    new_sum = sums + nums[index]
    if  new_sum == M:
        case += 1
    dfs(index + 1, new_sum)
    dfs(index + 1, sums)


N, M = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
nums.sort()
case = 0
dfs(0, 0)
print(case)

```

### &#127822; 풀이 방법

조합으로도 풀이할 수 있지만 최대한 이론대로 로직을 짜보면 다음과 같다.

1. nums에는 입력한 수열이, N에는 수열의 길이, M에는 목표하는 총합을 저장한다.

2. 순열을 순회하며, 해당 순서의 값을 포함, 포함하지 않는 부분순열로 분기하며 dfs한다.
    
3. 총합이 목표값과 동일할 때, case를 1 증가시킨다.

4. index가 N과 동일할 경우 수행하지않고 종료한다.

5. 마지막에는 case를 출력한다.

### &#127822; 느낀점

문제를 풀고나니, 유망성에 따라 연산을 줄이는 로직은 따로 없어 그냥 dfs같이 풀었다.

원래 작성했던 유망성 검사 부분은, 순열을 오름차순으로 정렬후, 목표값보다 현재 총합이 크면 더 깊이 탐색하지 않도록 하려고 했는데, 음수 양수가 모두 존재하기에 그런식으로 유망성을 거를수 없었다. 

처음에 permutation처럼 풀었다가 시행착오를 겪고 combination으로 적용하니 제대로 풀렸다.
# 백준3079\_입국심사

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
times = [int(sys.stdin.readline()) for _ in range(N)]

times.sort()
left = min(times) 
answer = right = max(times)*M

while left <= right:
    pivot = (left + right) // 2
    passed = 0
    for time in times:
        passed += pivot // time

    if passed >= M:
        right = pivot - 1
        answer = min(answer, pivot)
    else:
        left = pivot + 1

print(answer)
```

### &#127822; 풀이 방법

이 문제가 왜 이진 탐색으로 분류되었는지 처음에는 감이 잡히지 않았다.

단순 simulation으로 생각했다. 하지만 input값의 범위를 보고 simulation으로 하면 시간초과가 분명했다.

이 문제는 이진 탐색의 응용으로 매개 변수 탐색 유형이다.

이 경우,전체가 통과하는 걸리는 최소 시간이라는 변수 값을 이진탐색으로 찾는 문제이다.

1. 걸릴 수 있는 시간의 범위는 가장 빨리 처리하는 창구에 모두가 통과하는 시간 ~ 모두가 가장 오래걸리는 창구에서 통과하는 시간 이다.

2. 매번 중간값(pivot)의 시간이 해당 인원이 통과할 수 있는 충분한 시간인지 확인한다.

3. 충분한 경우, 중간값을 최대 시간으로, 부족한 경우, 중간값을 최소 시간으로 두고 이진 탐색을 진행.

4. 이진 탐색으로 구한 시간이 곧 주어진 조건을 만족하는 시간이다.

### &#127822; 느낀점

이진 탐색문제 유형과 매개변수 탐색 유형를 비교, 이해함.

처음엔 왜 이렇게 해야하지 이해하기 어려웠는데 비슷한 유형의 쉬운 문제를 몇개 푸니 유형이 이해되었다.

그리고 파이썬은 로직에 문제가 없더라도 시간초과가 또 나더라... 각 로직을 함수로 쪼개어 구현했더니 시간초과였다. 아래는 같은 로직의 시간초과난 코드

```python
import sys


def is_possible(p_num, time_limit):
    passed = 0

    for time in times:
        passed += time_limit // time

    if passed >= p_num:
        return True
    else:
        return False


def calc_time(people, min_time, max_time):
    left = min_time
    right = max_time
    while left < right:
        pivot = (left + right) // 2
        if is_possible(people, pivot):
            right = pivot - 1
        else:
            left = pivot

    return pivot


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().rstrip().split())

    times = [int(sys.stdin.readline()) for _ in range(N)]

    times.sort()
    Min_Time = min(times)
    Max_Time = max(times)*M
    print(calc_time(M, Min_Time, Max_Time))
```
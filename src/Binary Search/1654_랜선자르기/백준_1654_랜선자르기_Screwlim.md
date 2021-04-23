# 백준1654\_랜선 자르기

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys

K, N = map(int, sys.stdin.readline().rstrip().split())
lines = [int(sys.stdin.readline().rstrip()) for _ in range(K)]

ans = 0
_min = 1
_max = max(lines)


def check_cuts(limit):
    counts = 0
    for line in lines:
        counts += line // limit
    if counts >= N:
        return True
    else:
        return False


while _min <= _max:
    pivot = (_min + _max) // 2
    if check_cuts(pivot):
        ans = pivot
        _min = pivot + 1
    else:
        _max = pivot - 1

print(ans)
```

### &#127822; 풀이 방법

랜선토막 길이을 매개변수로 두고 이진탐색으로 적절한 값을 찾는다.

1. 입력값을 받아 저장한다.

2. 랜선의 길이는 최소 1, 최대 가장 긴 랜선의 길이이다. 

3. pivot값으로 주어진 길이를 활용해, 각 랜선 조각을 순회하며 몇개로 자를 수 있는 지 확인한다.

4. 잘린 랜선 조각의 갯수가 원하는 수보다 작으면, 조각의 길이를 줄이고, 크면, 조각의 길이를 늘인다.

5. 적절한 길이를 구할 때 까지 반복한다.

### &#127822; 느낀점

매개변수 탐색이 이제 익숙해서 쉬워진다.
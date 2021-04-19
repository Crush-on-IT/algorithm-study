# 백준10815\_숫자 카드

### &#127822; 분류

Binary Search

### &#127822; 코드

```python
import sys
input = sys.stdin.readline


def check(checkNum):
    left = 0
    right = M - 1
    while left < right:
        pivot = (left + right) // 2
        if cards[pivot] >= checkNum:
            right = pivot
        else:
            left = pivot + 1

    if cards[left] == checkNum:
        return 1
    else:
        return 0


if __name__ == "__main__":
    M = int(input())
    cards = list(map(int, input().split()))
    cards.sort()

    N = int(input())
    numbers = list(map(int, input().split()))

    for number in numbers:
        print(check(number), end=" ")
```

### &#127822; 풀이 방법

전형적인 이진탐색 문제이다.

가진 데이터(숫자 카드)에서 원하는 데이터(주어진 숫자들)을 찾고자 하는 문제이다.

1. 숫자카드를 입력받고 이진 탐색을 위해 sort한다.

2. check 함수에서 인자로 받은 함수를 찾는다.

3. 이진탐색을 실행하고 값이 특정되었을 때 일치하면 가지고 있는 것, 아니면 없는 것이다.

### &#127822; 느낀점

교과서에 나올 법한 이진탐색 기본문제
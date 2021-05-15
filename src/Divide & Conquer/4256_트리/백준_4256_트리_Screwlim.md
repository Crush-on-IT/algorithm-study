# 백준4256\_트리

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
import sys


def make_tree(_pre, _in):
    if len(_pre) <= 1:
        # head is leaf node
        return _pre

    head = _pre[0]
    in_head = _in.index(head)

    in_left = _in[0:in_head]
    in_right = _in[in_head+1:]

    pre_left = _pre[1:len(in_left)+1]
    pre_right = _pre[len(in_left)+1:]

    left = make_tree(pre_left, in_left)
    right = make_tree(pre_right, in_right)

    return left + right + [head]


t_num = int(sys.stdin.readline().rstrip())

for _ in range(t_num):
    node_num = int(sys.stdin.readline().rstrip())
    pre_order = list(map(int, sys.stdin.readline().rstrip().split()))
    in_order = list(map(int, sys.stdin.readline().rstrip().split()))
    ans = make_tree(pre_order, in_order)
    for i in ans:
        print(i, end=" ")
    print()

```

### &#127822; 풀이 방법

tree를 순회하는 로직이 재귀적인 것을 응용한 문제이다.

전위, 중위 순회한 결과를 토대로 후위순회한 결과를 출력한다.

1. 전위순회한 결과와 후위순회한 결과를 비교하여 각 수열을 left child, head, right child로 나눈다.

    1. 

3. 

4. 

### &#127822; 느낀점

분할 정복의 대표 예제 느낌이다. 이 분야도 DP처럼 많이 풀어봐야 할 듯

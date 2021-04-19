# 백준11663\_선분 위의 점

### &#127822; 분류

Binary Search

### &#127822; 코드

```python
import sys
input = sys.stdin.readline


def count_point(s, e):

    # 왼쪽 가장자리 점 찾기
    s_index = 0
    e_index = len(points) - 1
    while s_index <= e_index:
        left_end = (s_index + e_index) // 2
        if s <= points[left_end] <= e:
            e_index = left_end - 1
        else:
            if points[left_end] < s:
                s_index = left_end + 1
            elif points[left_end] > e:
                e_index = left_end - 1

    #오른쪽 가장자리 점 찾기
    s_index = 0
    e_index = len(points) - 1
    while s_index <= e_index:
        right_end = (s_index + e_index) // 2
        if s <= points[right_end] <= e:
            s_index = right_end + 1
        else:
            if points[right_end] < s:
                s_index = right_end + 1
            elif points[right_end] > e:
                e_index = right_end - 1

    cnt = right_end - left_end

    if s <= points[left_end] and points[right_end] <= e:
        return cnt + 1
    if s > points[left_end] and points[right_end] > e:
        return cnt - 1

    return cnt


if __name__ == "__main__":
    N, M = map(int, input().split())
    points = list(map(int, input().split()))
    points.sort()
    lines = []
    for _ in range(M):
        lines.append(list(map(int, input().split())))

    for line in lines:
        print(count_point(line[0], line[1]))
```

### &#127822; 풀이 방법
선분의 각 왼쪽, 오른쪽 끝을 포함하는 점을 찾을때, 이진 탐색으로 진행한다.

따라서 각 선분마다 두 번의 Log(N)연산이 발생한다.

1. 입력된 선분과 점을 list에 저장한다.

2. 각 선분마다 왼쪽 끝 보다 바로 한번 더 왼쪽에 있는 점, 오른쪽 끝 보다 바로 한번 더 오른쪽에 있는 점을 찾아야 한다. 이를 이진 탐색으로 수행한다.

3. 찾은 경우 오른쪽에서 왼쪽 인덱스를 빼서 점의 갯수를 구한다.

4. 선분이 주어진 점들의 값보다 초과해서 존재하는 경우, 주어진 선분이 양 쪽 끝 모두 지점보다 짧게 있는경우 각각 +1, -1로 예외처리를 해주어야 한다.

### &#127822; 느낀점

이진탐색은 항상 인덱스가 조금 햇갈리지만 명확히 정리하면 어렵지 않았다. 아직은 쉬운문제라 그럴수도.

코딩 스타일을 정리하며 알고리즘을 푸는 습관을 들이자.

# 백준1477\_휴게소 세우기

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys

N, M, L = map(int, sys.stdin.readline().rstrip().split())
stations = list(map(int, sys.stdin.readline().rstrip().split()))
stations.append(0)
stations.append(L)
stations.sort()
_min = 0
_max = L-1
ans = 1

while _min <= _max:
    pivot = (_min + _max) // 2
    built = 0
    for i in range(1, len(stations)):
        if stations[i] - stations[i-1] > pivot:
            built += (stations[i] - stations[i-1] - 1) // pivot

    if built > M:
        _min = pivot + 1
    else:
        ans = pivot
        _max = pivot - 1

print(ans)
```

### &#127822; 풀이 방법

매개변수 탐색 문제이다.

휴게소 간의 간격을 매개 변수로 두고 세울 수 있는 휴게소가 주어진 input에 맞도록 탐색한다.

1. 초기 범위는 0 ~ L-1 이다. (마지막 지점은 휴게소를 지을 수 없음)

2. 기존의 휴게소에 존재하는 위치를 저장해둔 stations에 0, L또 한 저장한다. stations를 순회하며 추가된 휴게소를 확인할 때 편의를 위해

3. pivot값을 설정하고, 해당 pivot값을 간격으로 사용할 때 몇개의 새로운 휴게소를 지을 수 있는지 확인한다. 목표값보다 크면 간격을 늘이고, 작거나 같으면 값을 저장하고 간격을 줄인다. (최대값의 최소를 구하기 때문)

4. 이진 탐색을 반복하면 적절한 값을 찾는다.

### &#127822; 느낀점

매개변수 탐색문제인데, 범위설정에서 조금 실수해서 시간이 걸렸다.

좀 더 풀어서 숙련도 높이도록 하자.

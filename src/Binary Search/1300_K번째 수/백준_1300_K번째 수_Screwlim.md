# 백준1300\_

### &#127822; 분류

Binary Search, Parametric Search

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())

ans = -1
_min = 1
_max = N*N

while _min <= _max:
    pivot = (_min + _max)//2
    print(_min, _max)
    smaller_nums = 0
    for i in range(1, N+1):
        smaller_nums += min(pivot//i, N)

    if smaller_nums >= K:
        ans = pivot
        _max = pivot - 1
    else:
        _min = pivot + 1
print(ans)
```

### &#127822; 풀이 방법

매개변수 탐색 문제이다.

어떠한 수 보다 작은 곱셈의 수들이 갯수가 K가 되는 값을 찾아야 한다.

1. 초기 범위는 1 ~ N*N 이다.

2. 어떠한 값보다 작은 곱의 갯수는 다음과 같이 count한다.
    
    i번째 행에는 ix1, ix2, ix3 ... 로 구구단처럼 값이 ixN까지 이어져 있다.

    이 값들 중에서 주어진 pivot값보다 작은 값의 갯수를 얻는 것은 pivot/i 의 몫이다.
    
    단, 해당 몫이 N보다 클경우, N을 더한다. 배열의 크기가 NxN이기 때문.
    
3. pivot값을 설정하고, 해당 pivot값을 답이라 생각하고 배열안에서 해당 값보다 작은 수의 갯수를 count한다.

4. 해당 count 값이 K보다 큰 경우, 값을 줄이는 방향으로, 작은경우, 값을 늘이는 방향으로 설정한다.

5. 이진탐색을 하여 적절한 K값을 찾는다.

### &#127822; 느낀점

이게 왜 이진탐색 문제인지 감이 안왔다.

처음에 생각 난 것은 주어진 조건에 따라 N만큼 이중 반복하며 생성되는 값을 배열에 넣고, sort한 후 K번째 원소를 출력하는 일이다.

하지만 이진탐색은 이런 과정을 더 빠르게 해준다는 장점을 살려 문제를 풀려고 하면, 또한 매개변수탐색 방법으로 정답을 구하는 방향을 역으로 생각해 보면, 

구하고자 하는 K번째 값은 앞에 K-1개의 작은 값들이 있고, 배열의 특징상 값들은 구구단처럼 규칙성있게 나열되어 있음을 알게 된다.

구조적으로 이미 sort기준이 정해져 있고, 구하고자 하는 값보다 작은 수들의 갯수를 알 수만 있다면 이진탐색방법으로 구할 수 있게 된다.

새로웠다.
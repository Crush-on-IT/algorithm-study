# 백준1463\_1로 만들기

### &#127822; 분류

Dynamic Programming

### &#127822; 코드

```python
import sys

N = int(sys.stdin.readline())
arr = [0, 0, 1, 1]

for i in range(4, N+1):
    arr.append(arr[i-1]+1)

    if i%2 == 0:
        arr[i] = min(arr[i], arr[i//2]+1)

    if i%3 == 0:
        arr[i] = min(arr[i], arr[i//3]+1)

print(arr[N])
```

### &#127822; 풀이 방법

각 수까지 이전의 최소 변환수의 값을 참고하여 최소값에 1씩 증가시켜 기록한다.

1. 0, 1, 2, 3은 각각 0, 0, 1, 1번만에 변할 수 있으므로 직접 값을 기록한다.

2. 4 이상의 수 부터는 이전 값, 2로 나눈 값, 3으로 나눈 값이 변환된 횟수를 조회하여 그 중 최소값에 1을 더해 기록한다.

3. N까지 2.를 반복한다.

### &#127822; 느낀점

DP가 Down-Top 방식이란 것을 확실히 보여주는 문제였다.
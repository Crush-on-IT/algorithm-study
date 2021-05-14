# 백준1493\_박스 채우기

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
import sys
sys.setrecursionlimit(1000000)
L, W, H = map(int, sys.stdin.readline().split())
n = int(sys.stdin.readline().rstrip())
cubes = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

cnt = 0
vol = L*W*H


def fill_the_box(l, w, h):
    global cubes, cnt, vol
    print("---------------------")
    print(l, w, h)
    if l <= 0 or w <= 0 or h <= 0:
        return

    for i in range(n-1, -1, -1):
        size = 2**cubes[i][0]
        if size <= l and size <= w and size <= h:
            #can do
            print("can do " + str(size))
            if cubes[i][1] > 0:
                print("do " + str(size))
                vol -= size**3
                cubes[i][1] -= 1
                cnt += 1
                fill_the_box(l-size, w, h)
                fill_the_box(size, w-size, h)
                fill_the_box(size, size, h-size)
                return

    print(-1)
    sys.exit()


fill_the_box(L, W, H)

print(vol)

if vol == 0:
    print(cnt)
else:
    print(-1)
```

### &#127822; 풀이 방법

우선 시간, 메모리 초과이긴 한데 로직은 맞는 것같아 올린다.

파이썬으로 시간, 메모리 초과를 극복하는건 좀 더 오래 고민해봐야 할 것 같아 고민중이다...

1. 상자에 가능한 최대 크기의 큐브를 넣는다.

2. 넣은 후 빈 공간은 3덩어리로 나눈다.

3. 다시 1로 돌아간다.

4. 남은 공간이 없거나, 남은 블럭이 없을때 까지 반복한다.

### &#127822; 느낀점

아무리봐도 이것 말고는 없어서 다른분들의 풀이를 봤는데, 자바는 로직이 비슷하고, 파이썬은 이상한 수학 공식을 적용해야 한다 해서 잠시 현타왔다. 좀 그런 문제인건가..
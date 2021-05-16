# 백준2374\_같은 수로 만들기

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
import sys

if __name__ == "__main__":

    n = int(sys.stdin.readline().rstrip())
    nums = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
    cleared_nums = [nums[0]]
    cnt = 0

    for i in nums:
        if cleared_nums[-1] != i:
            cleared_nums.append(i)

    while True:
        if len(cleared_nums) == 1:
            break

        target = cleared_nums.index(min(cleared_nums))
        two_even = False

        if target == 0:
            even = target+1
        elif target == len(cleared_nums)-1:
            even = target-1
        else:
            if cleared_nums[target-1] > cleared_nums[target+1]:
                even = target+1
            elif cleared_nums[target-1] < cleared_nums[target+1]:
                even = target-1
            else:
                even = target-1
                two_even = True

        cnt += cleared_nums[even] - cleared_nums[target]
        del cleared_nums[target]
        if two_even:
            del cleared_nums[even]

    print(cnt)
```

### &#127822; 풀이 방법

가장 낮은 값부터 마치 물을 붓는 것처럼 최대값까지 증가시키는 문제이다.

1. 입력값중 인접 중복되는 값을 제거한다.

2. 정리된 배열로부터 최소값을 찾고, 해당 값의 인접값 중 더 작은 값을 찾는다. 만약 양쪽 인접값이 같다면 flag = True

3. 인접값 - 최소값 만큼 cnt를 증가시킨다.

4. 최소값은 삭제한다. (이젠 중복되기 때문) flag가 True인 경우 반대쪽 인접값도 삭제

5. 배열의 길이가 1이 될때까지(모든 값이 같아진 경우) 2-4를 반복한다.

### &#127822; 느낀점

매 연산후 결과에서 연산대상을 새로 정하기에 재귀보다는 반복문에서 진행해 봤다.

로직은 분할정복인데 재귀를 안쓰고도 이렇게 푸는 경우도 있다고 생각하게 됨.
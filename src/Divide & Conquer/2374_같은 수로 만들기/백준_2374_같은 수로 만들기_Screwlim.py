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

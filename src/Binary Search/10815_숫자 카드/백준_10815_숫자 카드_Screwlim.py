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
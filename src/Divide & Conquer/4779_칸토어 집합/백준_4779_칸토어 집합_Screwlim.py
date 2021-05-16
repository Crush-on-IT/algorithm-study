def sol(n):
    ans = ["-" for _ in range(3 ** n)]

    ans = cantor(ans)

    for i in ans:
        print(i, end="")
    print()


def cantor(l):
    if len(l) == 1:
        return l

    div = len(l) // 3
    blank = l[div:div*2]
    for i in range(div):
        blank[i] = " "

    return cantor(l[:div]) + blank + cantor(l[:div])


if __name__ == "__main__":

    while True:
        try:
            n = int(input())
            sol(n)
        except EOFError:
            break


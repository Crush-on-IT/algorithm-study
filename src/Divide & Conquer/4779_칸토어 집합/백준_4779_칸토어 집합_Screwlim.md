# 백준4779\_칸토어 집합

### &#127822; 분류

Divide & Conquer

### &#127822; 코드

```python
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

```

### &#127822; 풀이 방법

주어진 수열을 잘라서 중간 부분을 공백처리하면 된다.

1. 배열을 받아 3등분한다.

2. 만약 받은 배열의 길이가 1이면 그대로 return

3. 중간 배열을 공백처리한다.

4. 처리된 배열을 합쳐서 return

### &#127822; 느낀점

계속 틀리길래 뭔지 봤더니 갑자기 파일로 입출력;

문제를 나누는 연습에 좋다.
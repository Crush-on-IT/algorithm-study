# 백준1935\_후위 표기식2

### &#127822; 분류

Stack

### &#127822; 코드

```python
import sys
operands_num = int(sys.stdin.readline().rstrip())
operands = []
equation = sys.stdin.readline().rstrip()

stack = []

for i in range(operands_num):
    operands.append(int(sys.stdin.readline().rstrip()))

for i in equation:

    if i == "+":
        a = stack.pop()
        b = stack.pop()
        stack.append(a+b)
    elif i == "-":
        a = stack.pop()
        b = stack.pop()
        stack.append(b - a)
    elif i == "*":
        a = stack.pop()
        b = stack.pop()
        stack.append(a * b)
    elif i == "/":
        a = stack.pop()
        b = stack.pop()
        stack.append(b / a)
    else:
        stack.append(operands[ord(i)-65])

print(format(stack.pop(), ".2f"))

```

### &#127822; 풀이 방법

후위표기식은 stack으로 다루기 쉬운 대표적인 연산이다. 다만 이번 문제는 변수 개념도 들어갔다. 변수를 따로 저장하여 불러오는 버퍼 역할을 하는 list를 활용하면 그만이다.

1. 우선 연산해야하는 식과 변수에 따른 값들을 받아 저장해 둔다.

2. 왼쪽에서부터 식을 하나씩 읽으며 연산자인 경우 stack에서 피연산자를 두개 꺼내어 연산한 뒤 다시 append

3. 피연산자의 경우 해당 변수의 값이 저장된 operands로 부터 값을 읽어 stack에 append한다.

4. 식이 모두 읽혀지고 나면 마지막엔 stack에 답만 남아있다.

### &#127822; 느낀점

계속 틀리길래 뭐지 했더니 소수점 두자리로 뱉으란다.
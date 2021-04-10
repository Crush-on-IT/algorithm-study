# 백준1918\_후위 표기식

### &#127822; 분류

Stack

### &#127822; 코드

```python
import sys

equation = sys.stdin.readline().rstrip()

stack = []
ans = ""

for i in equation:
    if i in "+-":
        while len(stack) != 0:
            temp = stack.pop()
            if temp in "+-*/":
                ans += temp
            else:
                stack.append(temp)
                break
        stack.append(i)
    elif i in "*/":
        if len(stack) != 0:
            temp = stack.pop()
            if temp in "*/":
                ans += temp
            else:
                stack.append(temp)
        stack.append(i)
    elif i == "(":
        stack.append(i)
    elif i == ")":
        while True:
            if len(stack) == 0:
                break
            temp = stack.pop()
            if temp == "(":
                break
            else: ans += temp
    else:
        ans += i

while len(stack) != 0:
    ans += stack.pop()

print(ans)
```

### &#127822; 풀이 방법

중위 표기식을 후위 표기식으로 변환하는 문제이다.
피연산자를 출력하고 연산이 이루어지는 순간에 따라 연산자를 출력하면 된다.

1. 문자는 순서가 그대로 유지되니 그대로 출력

2. 연산자의 경우 언제 연산이 이루어지는지 미정이니 stack에 저장한다.

3. +,-의 경우 다음 연산자를 만나는 순간 연산이 이루어짐 

4. *,/의 경우 다음 *,/ 연산자를 만나는 순간 연산이 이루어짐

5. '('의 경우 다음 ')'를 만나는 경우 stack에 쌓여있는 '(' 전까지 연산이 모두 이루어짐

### &#127822; 느낀점

이 문제를 만났을 때도 무작정 풀다가 왜 stack을 활용하는 것인지 추후에 생각하게 되었다.

연산자가 계산이 되는 순간은 3가지 조건에 따라 적용된다.
1. 연산이 나온 순서
2. 연산의 종류에 따른 우선순위
3. 괄호로 인한 우선순위

이 3가지 조건으로 인해 연산을 선입선출하지 못하고 들어온 순서에 따라 쌓아두어야 하고  이를 위해서는 stack이 적절한 자료구조이다.

이러한 부분을 많이 고려하지 못하고 문제를 풀려고 한 것 같다.
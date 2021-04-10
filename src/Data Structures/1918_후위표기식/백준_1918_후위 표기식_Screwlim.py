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
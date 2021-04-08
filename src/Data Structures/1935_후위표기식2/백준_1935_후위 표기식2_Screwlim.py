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

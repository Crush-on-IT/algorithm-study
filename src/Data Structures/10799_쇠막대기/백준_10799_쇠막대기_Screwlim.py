import sys
inputs = sys.stdin.readline().rstrip()

sticks = 0
tokens = 0
buffer = ''

for i in inputs:
    if i == '(':
        sticks += 1
    else:
        if buffer == '(':
            sticks -= 1
            tokens += sticks
        else:
            sticks -= 1
            tokens += 1
    buffer = i

print(tokens)
inputs = int(input())
stack = 0
ans = ""

for i in range(0, inputs):
    ps = input()

    for k in ps:
        if k == '(':
            stack += 1
        elif k == ')':
            stack -= 1
            if stack <0:
                ans += 'NO\n'
                stack = -1
                break
    if stack == 0:
        ans += 'YES\n'
        stack = 0
    elif stack == -1:
        stack = 0
    else:
        ans += 'NO\n'
        stack = 0
print(ans)

instr = [int(i) for i in input().split(' ')]

que = []
ans = []

for i in range(1,instr[0]+1):
    que.append(i)

i = 0
k = instr[1]-1
while(len(que) != 0) :
    i = i+k
    if i >= len(que):
        i = i%len(que)
    ans.append(que.pop(i))

print("<" + ", ".join(map(str,ans))+">")
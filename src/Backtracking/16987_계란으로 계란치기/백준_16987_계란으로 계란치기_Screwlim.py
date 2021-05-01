import sys


def breakEgg(egg_now, broken_num):
    global eggs, maxBroken, eggNum

    if egg_now == eggNum:
        maxBroken = max(maxBroken, broken_num)
        return

    if (eggNum - egg_now)*2 + broken_num < maxBroken:
        return

    if eggs[egg_now][0] <= 0:
        breakEgg(egg_now+1, broken_num)
    else:
        lonely_egg = True
        for i in range(eggNum):
            if eggs[i][0] > 0  and i != egg_now:
                lonely_egg = False
                eggs[i][0] -= eggs[egg_now][1]
                eggs[egg_now][0] -= eggs[i][1]
                temp = broken_num
                if eggs[i][0] <= 0:
                    temp += 1
                if eggs[egg_now][0] <= 0:
                    temp += 1
                breakEgg(egg_now + 1, temp)
                eggs[i][0] += eggs[egg_now][1]
                eggs[egg_now][0] += eggs[i][1]
        if lonely_egg:
            breakEgg(egg_now+1, broken_num)



eggNum = int(sys.stdin.readline().rstrip())
eggs = [list(map(int, sys.stdin.readline().split())) for _ in range(eggNum)]
maxBroken = 0
breakEgg(0, 0)
print(maxBroken)
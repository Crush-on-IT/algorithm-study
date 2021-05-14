import sys
sys.setrecursionlimit(1000000)
L, W, H = map(int, sys.stdin.readline().split())
n = int(sys.stdin.readline().rstrip())
cubes = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

cnt = 0
vol = L*W*H


def fill_the_box(l, w, h):
    global cubes, cnt, vol
    print("---------------------")
    print(l, w, h)
    if l <= 0 or w <= 0 or h <= 0:
        return

    for i in range(n-1, -1, -1):
        size = 2**cubes[i][0]
        if size <= l and size <= w and size <= h:
            #can do
            print("can do " + str(size))
            if cubes[i][1] > 0:
                print("do " + str(size))
                vol -= size**3
                cubes[i][1] -= 1
                cnt += 1
                fill_the_box(l-size, w, h)
                fill_the_box(size, w-size, h)
                fill_the_box(size, size, h-size)
                return

    print(-1)
    sys.exit()


fill_the_box(L, W, H)

print(vol)

if vol == 0:
    print(cnt)
else:
    print(-1)

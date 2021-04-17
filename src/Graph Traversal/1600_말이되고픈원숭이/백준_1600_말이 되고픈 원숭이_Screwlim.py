import sys
from collections import deque
input = sys.stdin.readline

k = int(input())
w, h = map(int, input().split())

map = [list(map(int, input().split())) for _ in range(h)]
visited = [[[0 for _ in range(k+1)] for _ in range(w)]for _ in range(h)]
# 모든 이동들을 말 움직임 횟수와 좌표로 구분하여 step수를 독립적으로 저장
stack = deque()

move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]

hmove_x = [2, 1, 2, -1, -2, -2, -1, 1]
hmove_y = [1, 2, -1, 2, -1, 1, -2, -2]
# 시작점과 도착점이 정해져있기 때문에 그 방향에 어긋나는 이동은 제외

def bfs():
    while stack:
        y, x ,h_num = stack.popleft()
        if x == w-1 and y == h-1:
            return visited[y][x][h_num]
        for i in range(4):
            now_x = x + move_x[i]
            now_y = y + move_y[i]
            if 0 <= now_x < w and 0 <= now_y < h and visited[now_y][now_x][h_num] == 0:
                if map[now_y][now_x] != 1:
                    stack.append([now_y, now_x, h_num])
                    visited[now_y][now_x][h_num] = visited[y][x][h_num]+1
        # horse move가 아직 가능한 케이스 / horse move를 모두 사용한 케이스는 스킵
        if h_num < k:
            for i in range(8):
                now_x = x + hmove_x[i]
                now_y = y + hmove_y[i]
                if 0 <= now_x < w and 0 <= now_y < h and visited[now_y][now_x][h_num+1] == 0:
                    if map[now_y][now_x] != 1:
                        stack.append([now_y, now_x, h_num+1])
                        visited[now_y][now_x][h_num+1] = visited[y][x][h_num] + 1
    return -1


stack.append([0, 0, 0])
print(bfs())
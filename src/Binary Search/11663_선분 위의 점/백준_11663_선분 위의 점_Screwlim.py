import sys
input = sys.stdin.readline


def count_point(s, e):

    # 왼쪽 가장자리 점 찾기
    s_index = 0
    e_index = len(points) - 1
    while s_index <= e_index:
        left_end = (s_index + e_index) // 2
        if s <= points[left_end] <= e:
            e_index = left_end - 1
        else:
            if points[left_end] < s:
                s_index = left_end + 1
            elif points[left_end] > e:
                e_index = left_end - 1

    #오른쪽 가장자리 점 찾기
    s_index = 0
    e_index = len(points) - 1
    while s_index <= e_index:
        right_end = (s_index + e_index) // 2
        if s <= points[right_end] <= e:
            s_index = right_end + 1
        else:
            if points[right_end] < s:
                s_index = right_end + 1
            elif points[right_end] > e:
                e_index = right_end - 1

    cnt = right_end - left_end

    if s <= points[left_end] and points[right_end] <= e:
        return cnt + 1
    if s > points[left_end] and points[right_end] > e:
        return cnt - 1

    return cnt


if __name__ == "__main__":
    N, M = map(int, input().split())
    points = list(map(int, input().split()))
    points.sort()
    lines = []
    for _ in range(M):
        lines.append(list(map(int, input().split())))

    for line in lines:
        print(count_point(line[0], line[1]))
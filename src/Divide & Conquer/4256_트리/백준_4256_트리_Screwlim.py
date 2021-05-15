import sys


def make_tree(_pre, _in):
    if len(_pre) <= 1:
        # head is leaf node
        return _pre

    head = _pre[0]
    in_head = _in.index(head)

    in_left = _in[0:in_head]
    in_right = _in[in_head+1:]

    pre_left = _pre[1:len(in_left)+1]
    pre_right = _pre[len(in_left)+1:]

    left = make_tree(pre_left, in_left)
    right = make_tree(pre_right, in_right)

    return left + right + [head]


t_num = int(sys.stdin.readline().rstrip())

for _ in range(t_num):
    node_num = int(sys.stdin.readline().rstrip())
    pre_order = list(map(int, sys.stdin.readline().rstrip().split()))
    in_order = list(map(int, sys.stdin.readline().rstrip().split()))
    ans = make_tree(pre_order, in_order)
    for i in ans:
        print(i, end=" ")
    print()

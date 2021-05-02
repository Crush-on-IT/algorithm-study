import sys


def try_team(player_number, cur_abil, test_case):
    global Tests, max_abil, recruited

    if (11 - player_number)*100 < max_abil - cur_abil:
        return

    if player_number == 11:
        max_abil = max(max_abil, cur_abil)
        return

    for i in range(11):
        if not recruited[i] and test_case[player_number][i] != 0:
            recruited[i] = True
            temp = cur_abil + test_case[player_number][i]
            try_team(player_number+1, temp, test_case)
            recruited[i] = False


N = int(sys.stdin.readline().rstrip())
Tests = [[list(map(int, sys.stdin.readline().split())) for _ in range(11)] for _ in range(N)]

for i in range(N):
    max_abil = 0
    recruited = [False] * 11
    try_team(0, 0, Tests[i])
    print(max_abil)
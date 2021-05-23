# 백준1865\_웜홀

### &#127822; 분류

Shortest Path, Bellman-Ford

### &#127822; 코드

```python
import sys


def bellmanFord():
    global time_travel

    for repeat in range(1, city + 1):
        for i in range(1, city + 1):
            print(distance)
            for wei, vec in graph[i]:
                if distance[vec] > distance[i] + wei:
                    distance[vec] = distance[i] + wei
                    #음의 사이클 발생함
                    if repeat == city:
                        time_travel = True
                        return
    
    #음의 사이클이 발생하지 않는다면 정상적으로 종료

# 테스트 케이스 수
N = int(sys.stdin.readline().rstrip())

#각 테스트 케이스별로 실행
for _ in range(N):
    city, road, worm_hole = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(city + 1)]
    INF = int(1e9)
    distance = [INF] * (city + 1)
    time_travel = False

    #road input
    for _ in range(road):
        s_node, d_node, weight = map(int, sys.stdin.readline().split())
        graph[s_node].append((weight, d_node))
        graph[d_node].append((weight, s_node))

    #worm hole input
    for _ in range(worm_hole):
        s_node, d_node, weight = map(int, sys.stdin.readline().split())
        graph[s_node].append((-weight, d_node))

    #check minus cycle with bellman-ford
    bellmanFord()

    #print result
    if time_travel:
        print('YES')
    else:
        print('NO')

```

### &#127822; 풀이 방법

Bellman-Ford 유형의 변형문제이다.

1. 테스트 케이스별로 입력값을 받는다. edge는 인접배열로, 최단거리를 위한 memoization은 1차원 배열로 선언한다. 도로는 양방향이기에 한번 받고 양방향 모두에 데이터를 넣고, 웜홀은 단방향으로 받고 weight를 음수로 넣어준다.

2. bellman ford를 실행한다.

3. 음의 사이클을 확인하기 위해 bellman ford를 활용하는 것이다. 따라서 어느 점이든 시작점으로 잡아도 되고, 시작점을 아예 설정하지 않아도 된다.

    bellman ford에서는 시작점을 설정하기를 distance배열에 시작점이 되는 index의 값을 0으로 설정해두면 되는데, 지금과 같은 경우는 그렇게 초기화 하지 않으면 된다.

    추가로 각 인접 노드들의 저장된 최단거리를 확인할 때, INF값일 경우 skip하는 조건을 두는데, 시작점을 설정하지 않으면 이 조건을 생략해 주어야 한다.

4. 마지막 순회를 할 때, 음의 사이클을 검사하고 없으면 flag를 그대로, 있으면 flag를 True로 바꿔 답을 출력한다.

### &#127822; 느낀점

정석이랑 변형 하나씩 풀면 해당 알고리즘 이해하는데 비교 분석하기 좋은 듯.

shortest path 재밌다.

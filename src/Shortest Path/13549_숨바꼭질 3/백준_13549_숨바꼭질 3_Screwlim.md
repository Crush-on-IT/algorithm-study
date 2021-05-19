# 백준11403\_경로 찾기

### &#127822; 분류

Shortest Path, Dijkstra

### &#127822; 코드

```python
import heapq
import sys

INF = int(1e9)

subin, sister = map(int, sys.stdin.readline().split())
distance = [INF] * 100001


def find_sister(start, end):

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[end] != INF:
            return
        if distance[now] < dist:
            continue

        dir = [[0, 2*now], [1, now - 1], [1, now + 1]]
        for i in dir:
            if i[1] < 0 or i[1] > 100000:
                continue
            cost = dist + i[0]
            if cost < distance[i[1]]:
                distance[i[1]] = cost
                heapq.heappush(q, (cost, i[1]))


find_sister(subin, sister)
print(distance[sister])
```

### &#127822; 풀이 방법

Dijkstra로 푸는 문제이지만, 그래프가 데이터로 주어지지 않고 정해진 규칙으로 생성된 문제이다.

1. q에 시작점을 넣고, q가 완전히 빌때 까지 아래를 반복한다.

2. q에서 가장 작은 값 (priority queue이기에 그냥 pop하면 됨.)을 꺼낸다.

3. 해당 값에 기록된 cost값이 이미 distance에 저장된 최단거리의 값보다 작은지 비교한다. 작지 않을 시, 탐색할 필요가 없으므로 반복문을 실행하지 않는다.

4. 해당 지점에서 인접한 지점을 방문하기 위해선 규칙에 따라, cost가 0으로 현재 node값의 두배, cost가 1로 현재 node값의 +1, -1을 방문할 수 있다.

5. 현재 지점까지의 cost와 다음 지점의 cost를 추가하여 얻은 값과, 이미 저장된 다음 node의 최단거리 값을 비교하여, 더 작을 경우 값을 갱신하고 해당 지점을 다시 q에 넣어준다.(앞으로 탐색해야할 경로에 포함시키는 것)

6. 만약 동생이 있는 지점에 도달했을 경우, 반복을 종료한다. (도달했기 때문)

### &#127822; 느낀점

어제 푼 문제랑 같이 둘다 비교하며 이해하니 시간이 걸렸지만 좀 더 깊게 이해한 것 같다.

(왜 priority queue를 쓰는지, 매번 최단거리를 선택하는 것이 어떤 결과를 가져오는지, DP, Greedy로 분류되는 이유 등등)

내용정리에 정리해서 올려둬야겠다.

Dijkstra는 별 거 많았다. ㅜ

제대로 이해하려니 볼 부분이 꽤 있었다.
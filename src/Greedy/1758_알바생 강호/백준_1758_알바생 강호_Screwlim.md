# 백준1758\_알바생 강호

### &#127822; 분류

Greedy

### &#127822; 코드

```python
import sys

customers = int(sys.stdin.readline().rstrip())
tips = []
answer = 0
for _ in range(customers):
    tips.append(int(sys.stdin.readline().rstrip()))

tips.sort(reverse=True)

for i in range(customers):
    temp = tips[i] - i
    if temp > 0:
        answer += temp
    else:
        continue

print(answer)
```

### &#127822; 풀이 방법

받는 값을 최대화 하기 위해서는 음수를 최대한 많이 만들어야 한다.

팁을 주는 고객의 수가 정해져있으니 등수에 따라 발생하는 감액은 언제나 동일하다. 단, 주려고 했던 팁보다 감액이 많아 음수가 발생하면 0원이 된다.

따라서 음수를 최대한 많이 발생시켜 감액량을 줄이면 된다.

1. 입력받은 팁을 내림차순으로 정렬한다.

2. 순회하며 등수에 따라 감액한다.

3. 감액한 금액이 음수이면 무시, 양수이면 총합에 추가한다.

4. 총합을 출력한다.

### &#127822; 느낀점

greedy에 적용하는 로직은 반례가 있으면 안됨.
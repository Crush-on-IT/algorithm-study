
# 정렬

### 관련 문제들

| 링크 | 수민 | 새음  |
|--|--|--|
| [https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751) |✅|✅|
| [https://www.acmicpc.net/problem/11650](https://www.acmicpc.net/problem/11650) |✅|✅|
| [https://www.acmicpc.net/problem/11651](https://www.acmicpc.net/problem/11651) |✅|✅|
| [https://www.acmicpc.net/problem/11656](https://www.acmicpc.net/problem/11656)|✅|✅|
| [https://www.acmicpc.net/problem/10814](https://www.acmicpc.net/problem/10814) |✅|✅|
| [https://www.acmicpc.net/problem/10825](https://www.acmicpc.net/problem/10825) |✅|✅|
| [https://www.acmicpc.net/problem/10989](https://www.acmicpc.net/problem/10989) |✅|✅|
| [https://www.acmicpc.net/problem/11652](https://www.acmicpc.net/problem/11652) |✅|✅|
| [https://www.acmicpc.net/problem/11004](https://www.acmicpc.net/problem/11004) |✅|✅|

   

<br>

## [issue]에 대한 정리

 - 정렬을 위한 인터페이스 Comparable & Comparator
- Comparable : 객체 간의 일반적인 정렬(기본 정렬)이 필요할 때 사용한다. Comparable 인터페이스 안에는  compareTo() 추상 메소드 하나만 존재. (주어진 객체(T o) 보다 작으면 음수, 같으면 0, 크면 양수를 리턴)
- Comparator : 객체 간의 특정한 정렬 (내가 원하는 대로 정렬하고 싶을 때 -내림차순 같은 거) 이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 int compare(T t1, T t2) 메서드를 구현.  (예시 : String, Integer를 역순으로 정렬 혹은 특정추가 조건)  

영어에서 'or'은 무언가를 하는 주체, 행위자를 나타내니까, 비교를 직접적으로 하도록 도와주는 기준을 정의하는 것이라 생각하면 좀 더 쉽다! 

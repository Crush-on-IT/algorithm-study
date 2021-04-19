# Graph Traversal(그래프 탐색)

[메인으로 돌아가기](https://github.com/Crush-on-IT/algorithm-study)

<br>

**_❗️❗️필수 개념❗️❗️_**

- BFS
- DFS
- 휴리스틱 탐색

<br>

## 개념 정리

| 수민                      | 새음 | 석렬 |
| ------------------------- | ---- | ---- |
| 여기에 개념 정리한 링크들 |      |      |

<br>

## 추천문제1 - 스택, 큐, 덱

| 순번 |                           문제 이름                            |                                       난이도                                        | 수민 | 새음 | 석렬 |
| :--: | :------------------------------------------------------------: | :---------------------------------------------------------------------------------: | :--: | :--: | :--: |
| 00 |<a href="http://boj.kr/2606" target="_blank">바이러스</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/8.svg"/> |✅|✅|✅|
| 01 |<a href="http://boj.kr/1260" target="_blank">DFS와 BFS</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/9.svg"/> |✅|✅|✅|
| 02 |<a href="http://boj.kr/11725" target="_blank">트리의 부모 찾기</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/9.svg"/> |✅|✅||
| 03 | <a href="http://boj.kr/1325" target="_blank">효율적인 해킹</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/9.svg"/> |||✅|
| 04 | <a href="http://boj.kr/2178" target="_blank">미로 탐색</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> ||✅|✅|
| 05 | <a href="http://boj.kr/2667" target="_blank">단지번호붙이기</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> ||✅|✅|
| 06 | <a href="http://boj.kr/7576" target="_blank">토마토</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> |✅|✅|✅|
| 07 | <a href="http://boj.kr/7569" target="_blank">토마토</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> ||✅||
| 08 | <a href="http://boj.kr/16918" target="_blank">봄버맨</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> ||||
| 09 | <a href="http://boj.kr/5547" target="_blank">일루미네이션</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/10.svg"/> ||||
| 10 | <a href="http://boj.kr/14502" target="_blank">연구소</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> |✅|✅||
| 11 | <a href="http://boj.kr/16234" target="_blank">인구 이동</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> |✅|✅||
| 12 | <a href="http://boj.kr/2636" target="_blank">치즈</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅||
| 13 | <a href="http://boj.kr/13549" target="_blank">숨바꼭질 3</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||||
| 14 | <a href="http://boj.kr/1600" target="_blank">말이 되고픈 원숭이</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅||
| 15 | <a href="http://boj.kr/17836" target="_blank">공주님을 구해라!</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅||
| 16 | <a href="http://boj.kr/16973" target="_blank">직사각형 탈출</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅||
| 17 | <a href="http://boj.kr/14940" target="_blank">쉬운 최단거리</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅|✅|
| 18 | <a href="http://boj.kr/18513" target="_blank">샘터</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||✅||
| 19 | <a href="http://boj.kr/2668" target="_blank">숫자고르기</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||||
| 20 | <a href="http://boj.kr/13023" target="_blank">ABCDE</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/11.svg"/> ||||
| 21 | <a href="http://boj.kr/16954" target="_blank">움직이는 미로 탈출</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> |✅|||
| 22 | <a href="http://boj.kr/2206" target="_blank">벽 부수고 이동하기</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> ||||
| 23 | <a href="http://boj.kr/2573" target="_blank">빙산</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> ||||
| 24 | <a href="http://boj.kr/4179" target="_blank">불!</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> ||||
| 25 | <a href="http://boj.kr/16932" target="_blank">모양 만들기</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> ||||
| 26 | <a href="http://boj.kr/9466" target="_blank">텀 프로젝트</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> ||||
| 27 | <a href="http://boj.kr/1967" target="_blank">트리의 지름</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> |✅|||
| 28 | <a href="http://boj.kr/17135" target="_blank">캐슬 디펜스</a> | <img height="25px" width="25px=" src="https://static.solved.ac/tier_small/12.svg"/> |✅|✅||


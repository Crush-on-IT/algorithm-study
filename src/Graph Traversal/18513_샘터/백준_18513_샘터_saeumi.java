package BFS_DFS;

import java.io.*;
import java.util.*;

public class 백준_18513_샘터_saeumi {

	static class house { // 현재 위치와 샘터로부터 거리 저장할 class
		int location;
		int distance;

		public house(int location, int distance) {
			this.location = location;
			this.distance = distance;
		}
	}

	private static int N, K;
	private static boolean[] visitPlus, visitMinus;
	private static Queue<house> queue = new LinkedList<house>();
	private static long result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //샘터
		K = Integer.parseInt(st.nextToken()); //집

		st = new StringTokenizer(br.readLine());
		visitPlus = new boolean[150000000]; // 0 ~ 100,100,000 까지 사용
		visitMinus = new boolean[150000000];// -100,100,000 ~ -1 까지 사용
		for (int i = 0; i < N; i++) {
			int location = Integer.parseInt(st.nextToken()); // 샘터 위치
			queue.offer(new house(location, 0)); // 샘터 다 큐에 넣기
			if (location < 0) // 위치가 음수라면
				visitMinus[-location] = true; // 음수 visit에 처리
			else if (location >= 0)// 위치가 양수라면
				visitPlus[location] = true; // 양수 visit에 처리

		}

		bfs();
		System.out.println(result); // 결과 출력
	}

	private static void bfs() {

		int dl[] = { -1, 1 }; // 현재 집으로 부터 지어질 양쪽집 방향
		int cnt = 0; // 세워진 집의 갯수
		result = 0; // 결과값

		gg: while (!queue.isEmpty()) { // bfs돌기
			house now = queue.poll();

			for (int i = 0; i < 2; i++) { // 두 방향에 대해
				int nextLocation = now.location + dl[i]; // 다음 방향 가보기
				int nextDistance = now.distance + 1; // 샘터하고 1만큼 더 멀어지기

				if (nextLocation >= 0 && visitPlus[nextLocation]) // 다음 위치가 양수면 양수 visit검사
					continue;
				if (nextLocation < 0 && visitMinus[-nextLocation]) // 다음 위치가 음수면 음수 visit검사
					continue;

				result += (long) nextDistance; // 아직 비어있는 공간이면 결과값 거리만큼 +
				cnt++; // 집도 지어졌으니 cnt ++

				if (cnt == K) // 모든 집 다 지었으면 종료
					break gg;

				queue.offer(new house(nextLocation, nextDistance)); // 다음집 집에 넣기
				if (nextLocation >= 0) // 다음 위치가 양수면
					visitPlus[nextLocation] = true; // 양수 visit 처리
				if (nextLocation < 0) // 음수면
					visitMinus[-nextLocation] = true; // 음수 visit처리

			}
		}
	}
}

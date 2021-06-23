import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static class Enemy {
		int x, y;

		Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int N, M, D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		// 입력받아진 적군의 위치를 객체리스트로 저장
		ArrayList<Enemy> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1) {
					list.add(new Enemy(i, j));
				}
			}
		}

		// 조합
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					// 적들의 위치를 복사 : 한텀이 다 끝나고 나서 적들을 제거해야 한다.
					ArrayList<Enemy> temp = new ArrayList<>();
					for (Enemy e : list) {
						temp.add(new Enemy(e.x, e.y));
					}

					// 게임 시작
					int r = game(temp, new int[] { i, j, k });
//					System.out.println(r);
					ans = Math.max(r, ans);
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

	static int ans = 0;

	static int game(List<Enemy> list, int[] pos) {
		int cnt = 0;
		// 적군이 모두 사라질때까지
		while (list.size() != 0) {
			List<Enemy> tmp = new ArrayList<>();
			for (int p : pos) {
				// 사수로부터 젤 가까운 적군의 위치를 찾아
				int target = findNear(list, p);
				// 사정거리내에 닿은 녀석이 없지 않다면
				if (target != -1) {
					// 죽일놈으로 추가
					tmp.add(list.get(target));
				}
			}
			// 죽일놈들을 리스트에서 삭제
			for (Enemy e : tmp) {
				if (list.remove(e))
					cnt++;
			}
			// 적군 하강
			enemyDown(list);
		}
		return cnt;
	}

	static int findNear(List<Enemy> list, int p) {
		int dist = 98765431;
		int minW = 50;
		int res = -1;
		for (int i = 0; i < list.size(); i++) {
			Enemy e = list.get(i);
			int d = N - e.x + Math.abs(p - e.y);
			// 거리 초과되는 적군은 무시
			if (d > D)
				continue;
			// 알고있던 거리보다 더 가까운 적이 나타나면
			if (d < dist) {
				// 적군과의 거리와 그 적군의 가로좌표를 저장
				dist = d;
				minW = e.y;
				res = i;
			}
			// 알고있는 가까운 적과 같은 거리를 갖는 적군이 발견되면
			else if (d == dist) {
				if (minW > e.y) {
					// 더 작은 가로 좌표값을 기억
					minW = e.y;
					res = i;
				}
			}
		}
		return res;
	}

	static void enemyDown(List<Enemy> list) {
		for (int i = 0; i < list.size(); i++) {
			Enemy e = list.get(i);
			e.x++;
			if (e.x == N) {
				list.remove(i);
				i--;
			}
		}
	}
}
package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_1966_프린터큐_saeumi {

	private static class Priority {
		int index;
		int prior;

		private Priority(int index, int prior) {
			super();
			this.index = index;
			this.prior = prior;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Priority> queue = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			int answer = 0;
			for (int now = 0; now < N; now++) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(new Priority(now, num));
			}

			while (!queue.isEmpty()) {
				Priority pri = queue.poll();
				boolean flag = true;
				for (Priority p : queue) {
					if (p.prior > pri.prior) { // 현재꺼보다 큰 우선순위가 나오면
						flag = false;
						queue.offer(pri);
						break;
					}
				}
				if (flag) {
					answer++;
					if (pri.index == M) {
						System.out.println(answer);
						break;
					}
				}

			}

		}

	} // end of main

} // end of class

package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_2346_풍선터뜨리기_saeumi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Deque<int[]> dq = new ArrayDeque<>();
	static int N;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dq.addLast(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		for (int i = 0; i < N; i++) {
			int next = dq.peekFirst()[0];
			sb.append(dq.peekFirst()[1] + " ");
			dq.removeFirst();

			if (dq.isEmpty())
				break;

			if (next > 0) {
				next--;
				while (next-- > 0) {
					dq.addLast(dq.peekFirst());
					dq.removeFirst();
				}
			} else {
				while (next++ < 0) {
					dq.addFirst(dq.peekLast());
					dq.removeLast();
				}
			}
		}

		System.out.println(sb.toString());
	}

}

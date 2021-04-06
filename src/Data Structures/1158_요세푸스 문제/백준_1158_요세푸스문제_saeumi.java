package Data_Structures;

import java.util.*;

public class 백준_1158_요세푸스문제_saeumi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (q.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ",  ");

		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}

}

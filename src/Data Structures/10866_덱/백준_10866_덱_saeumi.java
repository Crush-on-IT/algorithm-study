package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_10866_덱_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.contains("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			} else if (str.contains("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			} else if (str.contains("pop_front")) {
				sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
			} else if (str.contains("pop_back")) {
				sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
			} else if (str.contains("size")) {
				sb.append(deque.size()).append("\n");
			} else if (str.contains("empty")) {
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			} else if (str.contains("front")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
			} else if (str.contains("back")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
			}

		}

		System.out.println(sb);

	}
}

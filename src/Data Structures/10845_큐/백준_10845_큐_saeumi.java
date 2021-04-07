package Data_Structures;

import java.io.*;
import java.util.*;

public class 백준_10845_큐_saeumi {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int back = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 String input = st.nextToken();
			if (input.contains("push")) {
				int input2 = Integer.parseInt(st.nextToken());
				queue.offer(input2);
				back = input2;
			} else if (input.equals("pop")) {
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
			} else if (input.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (input.equals("empty")) {
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
			} else if (input.contains("front")) {
				sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
			} else if (input.contains("back")) {
				sb.append(queue.isEmpty() ? -1 : back).append("\n");
			}
		}
		System.out.println(sb);
	}
}
	 
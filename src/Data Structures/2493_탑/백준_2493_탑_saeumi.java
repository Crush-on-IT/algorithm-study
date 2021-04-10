package Data_Structures;

import java.io.*;
import java.util.*;

class top {
	int index;
	int height;

	public top(int index, int height) {
		super();
		this.index = index;
		this.height = height;

	}
}

public class 백준_2493_탑_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 탑의 개수
		Stack<top> top = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			while (!top.isEmpty()) {
				if (top.peek().height >= temp) {
					sb.append(top.peek().index + " ");
					break;
				}
				top.pop();
			}

			// 탑이 비어있을 때
			if (top.isEmpty()) {
				sb.append("0" + " ");
			}
			top.push(new top(i, temp));
		} // end of for

		System.out.println(sb);

	} // end of main
} // end of class

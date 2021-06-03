package Greedy;
import java.io.*;
import java.util.*;

public class 백준_1541_잃어버린괄호_saeumi { //다시 풀어보기 ! 

	public static void main(String[] args) throws IOException {
		// - 나오고 다음에 괄호를 묶으야 최소값이 될 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		int sum = Integer.MAX_VALUE;
		while (st.hasMoreTokens()) { // 리턴할 다음 토큰이 있으면 true를 다음 토큰이 없으면 false를 리턴한다.
			int answer = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			while (st2.hasMoreTokens()) {
				answer += Integer.parseInt(st2.nextToken());
			}
			if (sum == Integer.MAX_VALUE)
				sum = answer;
			else {
				sum -= answer;
			}
		}
		System.out.println(sum);
	}

}

package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class L1_BinaryGap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		//N을 이진수로 만든다
		while(N!=1) {
			stack.push(N%2);
			N /=2;
		}
		stack.push(1);
		
		int answer = 0;
		int cnt=0;
		//제일 긴 바이너리 갭을 찾는다.
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(cur==1) {
				answer = Math.max(answer, cnt);
				cnt=0;
			}
			else	++cnt;
		}
		System.out.println(answer);
	}

}

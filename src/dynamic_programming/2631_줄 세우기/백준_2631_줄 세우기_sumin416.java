import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N];
		int[] memo = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i]= Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		int left = 0, right = 0;
		
		//해당 인덱스의 숫자를 고정했을  때, 좌로 최장 증가수열
		for (int fix = 0; fix < N; fix++) {
			int beforeMax=0;
			for (int i = 0; i < fix; i++) {
				if(input[fix]>input[i]) {
					beforeMax= Math.max(beforeMax , memo[i]);
				}
			}
			memo[fix] = 1+ beforeMax;
		}
		
		for (int i = 0; i < memo.length; i++) {
			answer = Math.max(answer, memo[i]);
		}
		
		answer = N - answer;
		
		System.out.println(answer);
		
	}
	
}


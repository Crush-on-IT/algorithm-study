package codility;

import java.util.Arrays;

public class L4_MaxCounters {
	public static void main(String[] args) {
		int[] answer = solution(5,new int[] {3,4,4,6,1,4,4});
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int N, int[] A) {
		int[] answer = new int[N];
		int max = 0;
		int maxCounter = 0;
		for(Integer num : A) {
			if(num == N+1) {
				maxCounter = max;
			}
			else {
				if(answer[num-1]<maxCounter)	answer[num-1] = maxCounter+1;
				else	++answer[num-1];
				max = Math.max(max, answer[num-1]);
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			if(answer[i]<maxCounter)	answer[i] = maxCounter;
		}
		return answer;
	}
}

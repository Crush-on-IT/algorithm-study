package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기_oct14jh {
	private static int N;
	private static PriorityQueue<Integer> pq = new PriorityQueue<>();
	private static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while(!pq.isEmpty()) {
			if(pq.size() == 1) { 
				if(result == 0)
					result = 0;
				
				break;
			}
			int temp = 0;
			int firstMin = pq.poll();
			int secondMin = pq.poll();
			temp = firstMin + secondMin;
			result += temp;
			pq.offer(temp);
		}
		
		System.out.println(result);
	}
}

/**

*/

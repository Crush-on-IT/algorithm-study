package Data_Structures;

import java.util.*;

public class 백준_2164_카드2 { //요세푸스랑 거의 똑같은 문제 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i ++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			for(int i =0; i<=N-2; i++) {
				queue.remove();
				queue.offer(queue.poll());
			}
		}
		System.out.println(queue.poll());
		
	}

}

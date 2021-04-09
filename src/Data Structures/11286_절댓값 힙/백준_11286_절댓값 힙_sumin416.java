import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1-o2;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		
		int cur;
		for (int i = 0; i < N; i++) {
			cur = Integer.parseInt(br.readLine());
			
			switch(cur) {
				case 0:
					sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
					break;
				default:
					pq.offer(cur);
					break;
			}
		}
		System.out.println(sb.toString());
	}

}

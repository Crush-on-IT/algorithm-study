
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int last = -1;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "push":
					num = -2;
					last = Integer.parseInt(st.nextToken());
					queue.offer(last);
					break;
				case "pop":
					num=queue.isEmpty()?-1:queue.poll();
					break;
				case "size":
					num=queue.size();
					break;
				case "empty":
					num=queue.isEmpty()?1:0;
					break;
				case "front":
					num=queue.isEmpty()?-1:queue.peek();
					break;
				case "back":
					num=queue.isEmpty()?-1:last;
					break;
			}
			
			if(num!=-2) {
				sb.append(num).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}

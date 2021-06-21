import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0_oct14jh {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(getAnswer());
	}
	private static String getAnswer() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <=N ; i++) {
			queue.offer(i);
		} // 모든 사람을 큐에 번호 순서대로 넣는다.
		
		int cur,cnt = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			cur = queue.poll();
			// k의 배수인 애들은 다시 넣지 않고 결과에 넣고 다음으로.
			if(++cnt%K==0) sb.append(cur).append(", ");
			// k의 배수가 아닌 애들은 다시 넣는다.
			else queue.offer(cur);
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		return sb.toString();
		
	}
}

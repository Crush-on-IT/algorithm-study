import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static class Node{
		int idx;
		int value;
		
		public Node() {
			super();
		}

		public Node(int idx, int value) {
			super();
			this.idx = idx;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", value=" + value + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Deque<Node> dq = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			dq.offer(new Node(i,Integer.parseInt(st.nextToken())));
		}
		
		
		
		List<Integer> answer = new ArrayList<>();
		Node cur;
		
		while(!dq.isEmpty()) {
			cur = dq.pollFirst();
			
			answer.add(cur.idx);
			
			if(dq.isEmpty())	break;
			
			if(cur.value>0) {
				for (int j = 1; j < cur.value; j++) {
					dq.addLast(dq.pollFirst());
				}
			}else {
				for (int i = 1; i <= cur.value*-1; i++) {
					dq.addFirst(dq.pollLast());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer num : answer) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	
	
}

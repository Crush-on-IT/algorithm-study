import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int start,end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(1);
		visited[1] = true;
		int cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			for(Integer integer : graph.get(cur)) {
				if(!visited[integer]) {
					visited[integer]  = true;
					queue.offer(integer);
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if(visited[i])	++answer;
		}
		
		System.out.println(answer-1);
	}
}

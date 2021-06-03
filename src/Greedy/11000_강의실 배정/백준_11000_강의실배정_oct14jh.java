package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	
	private static class Class {
		int start;
		int end;
		public Class() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	private static int N;
	private static ArrayList<Class> classes = new ArrayList<>();
	private static PriorityQueue<Class> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			classes.add(new Class(start, end));
		}
		
		Collections.sort(classes, (a, b) -> a.start - b.start);
		pq.add(classes.get(0));
		
		for(int i = 1; i < classes.size(); i++) {
			Class temp = classes.get(i);
			
			if(temp.start >= pq.peek().end)
				pq.poll();
			pq.add(temp);
		}
		
		System.out.println(pq.size());
	}
}

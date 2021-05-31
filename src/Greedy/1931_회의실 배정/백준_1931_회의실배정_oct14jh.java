package com.ssafy.algo.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Conference {
	int start, end;
	public Conference() {};
	public Conference(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "Conference [start=" + start + ", end=" + end + "]";
	}
	
}

class comparatorConference implements Comparator<Conference>{

	@Override
	public int compare(Conference o1, Conference o2) {
		if(o1.end == o2.end)
			return -(o1.start - o2.start);
		return o1.end - o2.end;
	}
}

public class 회의실배정 {
	static int N, cnt=0;
	static Conference[] parents;
	static Conference[] conferences;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		conferences = new Conference[N];
		parents = new Conference[N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			conferences[i] = new Conference(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
//		makeSet();
		Arrays.sort(conferences, new comparatorConference());
		
		for(Conference e : conferences)
			System.out.println(e.toString());
		
	}
	
//	static void makeSet() {
//		for(int i=0; i<N; i++) {
//			parents[i] = conferences[i].end;
//		}
//	}
//	
////	static int findSet(int x) {
////		if(parents[x] == x) return x;
////		return x = findSet(parents[x]);
////	}
//	
//	static void unionSet(int x, int y) {
//		x = findSet(x);
//		y = findSet(y);
//		if(x != y)
//			parents[y] = parents[findSet(x)];
//	}
}
